package com.wake.nlkm.service.impl;

import com.wake.nlkm.entity.Guwen;
import com.wake.nlkm.error.AddDataFailException;
import com.wake.nlkm.error.FailException;
import com.wake.nlkm.mapper.GuwenMapper;
import com.wake.nlkm.service.GuwenService;
import com.wake.nlkm.utils.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Ganty
 * @Date 2020/8/21
 * @Des
 */

@Service
public class GuwenServiceImpl implements GuwenService {

    @Autowired
    private GuwenMapper guwenMapper;

    /**
     * 批量查询古文
     *
     * @param title
     * @param page
     * @param limit
     * @return
     */
    @Override
    public RespPageBean queryGuwenByBatch(String title, Integer page, Integer limit) throws Exception {

        int total = guwenMapper.selectCount(title);
        Integer offset = 0;
        if (page > 0) {
            offset = (page -1) * limit;
        }
        List<Guwen> guwenList = guwenMapper.selectByBatch(title, offset, limit);
        RespPageBean respPageBean = new RespPageBean(guwenList);
        respPageBean.setProperty(total, page, limit);

        return respPageBean;
    }

    /**
     * 通过古文id查询古文详情
     *
     * @param guwenId
     * @return
     * @throws Exception
     */
    @Override
    public Guwen queryGuwenById(Integer guwenId) throws Exception {
        Guwen guwen = guwenMapper.selectByPrimaryKey(guwenId);
        return guwen;
    }

    /**
     * 通过标题查询古文
     *
     * @param title
     * @return
     */
    @Override
    public RespPageBean queryGuwenInfoByTitle(String title) throws Exception {
        int total;
        List<Guwen> guwenLisTotal = guwenMapper.selectBytitle(title);
        // 查询的古文标题和出来来的古文中的标题进行排序。
        List<Guwen> guwenList = new ArrayList<Guwen>();
        if(guwenLisTotal.size() >20){
            total = 20;
            for(int i =0; i<20;i++){
                guwenList.add(guwenLisTotal.get(i));
            }
        } else {
            guwenList = guwenLisTotal;
        }
        RespPageBean respPageBean = new RespPageBean(guwenList);
        respPageBean.setProperty(guwenList.size(), 1,1);
        return respPageBean;
    }

    /**
     * 新增古文
     *
     * @param guwenInfo
     * @return
     */
    @Override
    public int addGuwenInfo(Guwen guwenInfo) throws Exception {
        int flag = guwenMapper.insertSelective(guwenInfo);
        if (flag == 0){
            throw new AddDataFailException();
        }
        return guwenInfo.getId();
    }

    /**
     * 更新古文信息
     *
     * @param guwenInfo
     * @return
     */
    @Override
    public int updateGuwenInfo(Guwen guwenInfo) throws Exception {
        Date updatetime = new Date();
        guwenInfo.setUpdatetime(updatetime);
        int flag = guwenMapper.updateByPrimaryKeySelective(guwenInfo);
        if (flag == 0){
            throw new FailException("新增古文失败");
        }
        return flag;
    }

    /**
     * 删除古文
     *
     * @param guwenId
     * @return
     */
    @Override
    public int deleteGuwen(Integer guwenId) throws Exception {
        int flag = guwenMapper.updateDelete(guwenId);
        if (flag == 0) {
            throw new FailException("古文删除失败");
        }
        return flag;
    }

    /**
     * 更新古文审核状态
     *
     * @param id
     * @param state
     * @return
     */
    @Override
    public int updateGuwenCheckState(Integer id, Integer state) throws Exception {
        Date updatetime = new Date();
        int flag = guwenMapper.updateCheckState(id, state, updatetime);
        if(flag == 0){
            throw new FailException("更新古文审核状态失败");
        }
        return flag;
    }
}
