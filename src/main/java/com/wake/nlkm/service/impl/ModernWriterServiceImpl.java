package com.wake.nlkm.service.impl;

import com.wake.nlkm.entity.ModernWriter;
import com.wake.nlkm.error.FailException;
import com.wake.nlkm.mapper.ModernWriterMapper;
import com.wake.nlkm.service.ModernWriterService;
import com.wake.nlkm.utils.Constant;
import com.wake.nlkm.utils.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author Ganty
 * @Date 2020/8/24
 * @Des
 */

@Service
public class ModernWriterServiceImpl implements ModernWriterService {

    @Autowired
    private ModernWriterMapper modernWriterMapper;

    /**
     * 批量查询现代作家
     *
     * @param page
     * @param limit
     * @return
     */
    @Override
    public RespPageBean queryWriterBatch(String name, Integer page, Integer limit) throws Exception {
        Integer total = modernWriterMapper.selectCount(name);

        Integer offset = 0;
        if (page > 0) {
            offset = (page-1) * limit;
        }

        List<ModernWriter> modernWriters = modernWriterMapper.selectByBatch(name,offset, limit);
        RespPageBean respPageBean = new RespPageBean(modernWriters);
        respPageBean.setProperty(total, page, limit);

        return  respPageBean;
    }

    /**
     * 通过名字，查询指定作家详情
     *
     * @param name
     * @return
     */
    @Override
    public RespPageBean queryWriterInfoByName(String name) throws Exception {
        List<ModernWriter> modernWriters = modernWriterMapper.selectByName(name);

        RespPageBean respPageBean = new RespPageBean();
        if(modernWriters.size() > 0){
            respPageBean.setProperty(modernWriters.size(),1,20);
            respPageBean.setData(modernWriters);
        }
        return respPageBean;
    }

    /**
     * 通过作家ID， 查询指定作家详情
     *
     * @param writerid
     * @return
     */
    @Override
    public ModernWriter queryWriterInfoById(Integer writerid) throws Exception {

        ModernWriter writer = modernWriterMapper.selectByPrimaryKey(writerid);

        return writer;
    }

    /**
     * 新增作家及信息
     *
     * @param writerInfo
     * @return
     */
    @Override
    public int addWriterInfo(ModernWriter writerInfo) throws Exception {

        int flag = modernWriterMapper.insertSelective(writerInfo);
        if(flag == 0){
            throw new FailException("新增现代作家失败");
        }
        return writerInfo.getId();
    }

    /**
     * 更新作家信息
     *
     * @param writerInfo
     * @return
     */
    @Override
    public int updateWriterInfo(ModernWriter writerInfo) throws Exception {

        int flag  = modernWriterMapper.updateByPrimaryKey(writerInfo);
        if(flag == 0){
            throw new FailException("作家信息更新失败");
        }

        return flag;
    }

    /**
     * 删除作家
     *
     * @param writerId
     * @return
     */
    @Override
    public int deleteWriterById(Integer writerId) throws Exception {

        int flag = modernWriterMapper.updateDelete(writerId, Constant.DELETEFLAG, new Date());
        if(flag == 0){
            throw new FailException("删除现代作家信息失败");
        }

        return flag;
    }

    /**
     * 更新作家信息审核状态
     *
     * @param writerId
     * @return
     */
    @Override
    public int updateWriterCheckState(Integer writerId, Integer state) throws Exception {
        int flag = modernWriterMapper.updateCheckState(writerId, state, new Date());
        if(flag == 0){
            throw new FailException("更新现代作家审核标志失败");
        }

        return flag;
    }
}
