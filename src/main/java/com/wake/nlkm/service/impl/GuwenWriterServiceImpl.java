package com.wake.nlkm.service.impl;

import com.wake.nlkm.entity.Author;
import com.wake.nlkm.entity.ModernWriter;
import com.wake.nlkm.error.FailException;
import com.wake.nlkm.mapper.AuthorMapper;
import com.wake.nlkm.mapper.ModernWriterMapper;
import com.wake.nlkm.service.GuwenWriterService;
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
public class GuwenWriterServiceImpl implements GuwenWriterService {

    @Autowired
    private AuthorMapper authorMapper;

    /**
     * 批量查询古代作家
     *
     * @param name
     * @param page
     * @param limit
     * @return
     */
    @Override
    public RespPageBean queryWriterBatch(String name, Integer page, Integer limit) throws Exception {
        Integer total = authorMapper.selectCount(name);

        Integer offset = 0;
        if (page > 0) {
            offset = (page -1) * limit;
        }
        List<Author> modernWriters = authorMapper.selectByBatch(name, offset, limit);
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
        List<Author> modernWriters = authorMapper.selectByName(name);

        RespPageBean respPageBean = new RespPageBean();
        if(modernWriters.size() > 0){
            respPageBean.setData(modernWriters);
            respPageBean.setProperty(modernWriters.size(), 1,1);
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
    public Author queryWriterInfoById(Integer writerid) throws Exception {

        Author writer = authorMapper.selectByPrimaryKey(writerid);

        return writer;
    }

    /**
     * 新增作家及信息
     *
     * @param writerInfo
     * @return
     */
    @Override
    public int addWriterInfo(Author writerInfo) throws Exception {

        int flag = authorMapper.insertSelective(writerInfo);
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
    public int updateWriterInfo(Author writerInfo) throws Exception {

        int flag  = authorMapper.updateByPrimaryKeySelective(writerInfo);
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

        int flag = authorMapper.updateDelete(writerId, Constant.DELETEFLAG, new Date());
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
        int flag = authorMapper.updateCheckState(writerId, state, new Date());
        if(flag == 0){
            throw new FailException("更新现代作家审核标志失败");
        }

        return flag;
    }
}
