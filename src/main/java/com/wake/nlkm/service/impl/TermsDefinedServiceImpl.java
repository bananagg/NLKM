package com.wake.nlkm.service.impl;

import com.wake.nlkm.entity.Author;
import com.wake.nlkm.entity.TermsDefined;
import com.wake.nlkm.error.FailException;
import com.wake.nlkm.mapper.TermsDefinedMapper;
import com.wake.nlkm.service.TermsDefinedService;
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
public class TermsDefinedServiceImpl implements TermsDefinedService {

    @Autowired
    private TermsDefinedMapper termsDefinedMapper;
    /**
     * 批量查询术语
     *
     * @param name
     * @param page
     * @param limit
     * @return
     */
    @Override
    public RespPageBean queryTermsDefinedBatch(String name, Integer page, Integer limit) throws Exception {
        Integer total = termsDefinedMapper.selectCount(name);
        Integer offset = page * limit - limit;
        List<TermsDefined> termsDefineds = termsDefinedMapper.selectByBatch(name, offset, limit);
        RespPageBean respPageBean = new RespPageBean( termsDefineds);
        respPageBean.setProperty(total, page, limit);

        return respPageBean;
    }

    /**
     * 通过名字，查询指定术语详情
     *
     * @param name
     * @return
     */
    @Override
    public RespPageBean queryTermsDefinedIByName(String name) throws Exception {

        List<TermsDefined> termsDefineds = termsDefinedMapper.selectByName(name);
        RespPageBean respPageBean = new RespPageBean();
//        respPageBean.setTotal(new Long(termsDefineds.size()));
//        respPageBean.setData(termsDefineds);
        return respPageBean;
    }

    /**
     * 通过ID， 查询指定术语定义详情
     *
     * @param writerid
     * @return
     */
    @Override
    public TermsDefined queryTermsDefinedById(Integer writerid) throws Exception {
        TermsDefined termsDefined = termsDefinedMapper.selectByPrimaryKey(writerid);

        return termsDefined;
    }

    /**
     * 新增术语定义
     *
     * @param termsDefinedInfo
     * @return
     */
    @Override
    public int addTermsDefined(TermsDefined termsDefinedInfo) throws Exception {
        int flag = termsDefinedMapper.insert(termsDefinedInfo);
        if(flag == 0 || termsDefinedInfo.getId() == null || termsDefinedInfo.getId() == 1) {
            throw new FailException("新增术语定义失败");
        }
        return termsDefinedInfo.getId();
    }

    /**
     * 更新作家信息
     *
     * @param termsDefinedInfo
     * @return
     */
    @Override
    public int updateTermsDefined(TermsDefined termsDefinedInfo) throws Exception {
        int flag = termsDefinedMapper.updateByPrimaryKey(termsDefinedInfo);
        if (flag == 0){
            throw new FailException("术语定义信息更新失败");
        }
        return flag;
    }

    /**
     * 删除作家
     *
     * @param termsDefinedId
     * @return
     */
    @Override
    public int deleteTermsDefinedById(Integer termsDefinedId) throws Exception {
        int flag = termsDefinedMapper.updateDelete(termsDefinedId, Constant.DELETEFLAG, new Date());
        if (flag == 0){
            throw new FailException("术语删除失败");
        }
        return flag;
    }

    /**
     * 更新作家信息审核状态
     *
     * @param termsDefinedId
     * @param state
     * @return
     */
    @Override
    public int updateTermsDefinedCheckState(Integer termsDefinedId, Integer state) throws Exception {
        int flag = termsDefinedMapper.updateCheckState(termsDefinedId, state, new Date());
        if (flag == 0) {
            throw new FailException("更新术语审核标志失败");
        }

        return flag;
    }
}
