package com.wake.nlkm.service.impl;

import com.wake.nlkm.entity.Radical;
import com.wake.nlkm.error.FailException;
import com.wake.nlkm.mapper.RadicalMapper;
import com.wake.nlkm.service.RadicalService;
import com.wake.nlkm.utils.Constant;
import com.wake.nlkm.utils.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author Ganty
 * @Date 2020/8/26
 * @Des
 */

@Service
public class RadicalServiceImpl implements RadicalService {

    @Autowired
    private RadicalMapper radicalMapper;
    /**
     * 批量查询部首及叫法
     *
     * @param page
     * @param limit
     * @return
     */
    @Override
    public RespPageBean queryRadicalByBatch(Integer page, Integer limit) throws Exception {
        Integer total = radicalMapper.selectCount();
        Integer offset = page * limit - limit;
        List<Radical> radicalList = radicalMapper.selectByBatch(offset, limit);
        RespPageBean respPageBean = new RespPageBean(radicalList);
        respPageBean.setProperty(total, page, limit);
        return respPageBean;
    }

    /**
     * 查询指定部首
     *
     * @param radicalId
     * @return
     */
    @Override
    public Radical queryRadicalInfo(Integer radicalId) throws Exception {

        return radicalMapper.selectByPrimaryKey(radicalId);
    }

    /**
     * 新增部首及叫法
     *
     * @param radicalInfo
     * @return
     */
    @Override
    public int addRadicalInfo(Radical radicalInfo) throws Exception {
        int flag = radicalMapper.insertSelective(radicalInfo);
        if (flag == 0){
            throw new FailException("新增部首叫法失败");
        }
        return radicalInfo.getId();
    }

    /**
     * 更新部首叫法
     *
     * @param radicalInfo
     * @return
     */
    @Override
    public int updateRadicalInfo(Radical radicalInfo) throws Exception {
        int flag = radicalMapper.updateByPrimaryKeySelective(radicalInfo);
        return flag;
    }

    /**
     * 删除部首叫法
     *
     * @param radicalId
     * @return
     */
    @Override
    public int deleteRadicalById(Integer radicalId) throws Exception {
        int flag = radicalMapper.updateDelete(radicalId, Constant.DELETEFLAG, new Date());
        return flag;
    }

    /**
     * 更新部首叫法的审核状态
     *
     * @param radicalId
     * @param state
     * @return
     */
    @Override
    public int updateRadicalCheckState(Integer radicalId, Integer state) throws Exception {
        int flag = radicalMapper.updateCheckState(radicalId, state, new Date());
        return flag;
    }
}
