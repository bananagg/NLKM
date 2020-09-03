package com.wake.nlkm.service.impl;

import com.wake.nlkm.entity.Idiom;
import com.wake.nlkm.error.DataExitException;
import com.wake.nlkm.error.DataNotExitException;
import com.wake.nlkm.error.FailException;
import com.wake.nlkm.mapper.IdiomMapper;
import com.wake.nlkm.service.IdiomService;
import com.wake.nlkm.utils.RespPageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author Ganty
 * @Date 2020/8/21
 * @Des
 */
@Transactional
@Service
public class IdiomServiceImpl implements IdiomService {
    private static final Logger logger = LoggerFactory.getLogger(IdiomServiceImpl.class);

    @Autowired
    private IdiomMapper idiomMapper;

    /**
     * 批量查询成语
     *
     * @param word
     * @param page
     * @param limit
     * @return
     */
    @Override
    public RespPageBean queryIdiomByBatch(String word, Integer page, Integer limit) throws Exception {
        Integer total = idiomMapper.selecetCount(word);
        Integer offset = 0;
        if (page > 0) {
            offset = (page -1) * limit;
        }
        List<Idiom> idiomList = idiomMapper.selectByBatch(word, offset, limit);
        RespPageBean respPageBean = new RespPageBean(idiomList);
        respPageBean.setProperty(total, page, limit);

        return respPageBean;
    }

    /**
     * 查询指定成语详情
     *
     * @param word
     * @return
     */
    @Override
    public Idiom queryIdiomInfo(String word) throws Exception {
        Idiom idiom;
        try {
            idiom = idiomMapper.selectByWord(word);
        } catch (Exception e){
            throw new Exception();
        }
        return idiom;
    }

    /**
     * 根据id查询成语信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Idiom queryIdiomById(Integer id) throws Exception {
        Idiom idiom = idiomMapper.selectByPrimaryKey(id);
        if (idiom == null) {
            throw new DataNotExitException();
        }
        return idiom;
    }

    /**
     * 新增成语
     *
     * @param idiomInfo
     * @return
     */
    @Override
    public int addIdiomInfo(Idiom idiomInfo) throws Exception {
        int flag;
        Idiom idiom = idiomMapper.selectByWord(idiomInfo.getWord());
        if(idiom != null){
            throw new DataExitException();
        }
        flag = idiomMapper.insertSelective(idiomInfo);
        if(flag == 0){
            throw new FailException("新增成语失败");
        }

        return idiomInfo.getId();
    }

    /**
     * 更新成语信息
     *
     * @param idiomInfo
     * @return
     */
    @Override
    public int updateIdiomInfo(Idiom idiomInfo) throws Exception {
        int flag = 0;
        try {
            Idiom idiom = idiomMapper.selectByWord(idiomInfo.getWord());
            if(idiom == null){
                throw new DataNotExitException();
            }
            idiomInfo.setUpdatetime(new Date());
            flag = idiomMapper.updataByWord(idiomInfo);
            if(flag == 0){
                throw new FailException("更新成语失败");
            }
        } catch (Exception e){
            e.printStackTrace();
            logger.error("异常{}",e);
            throw new FailException("更新成语失败");

        }
        return flag;
    }

    /**
     * 删除成语
     *
     * @param idiomName
     * @return
     */
    @Override
    public int deleteIdiom(String idiomName) throws Exception {
        Idiom idiom = idiomMapper.selectByWord(idiomName);
        if(idiom == null) {
            throw new DataNotExitException();
        }
        int flag = idiomMapper.deleteByWord(idiomName);
        return flag;
    }

    /**
     * 删除成语
     *
     * @param id
     * @return
     */
    @Override
    public int deleteIdiomById(Integer id) throws Exception {
        Idiom idiom = idiomMapper.selectByPrimaryKey(id);
        if (idiom == null) {
            throw new DataNotExitException();
        }
        int flag = idiomMapper.deleteByPrimaryKey(id);
        return flag;
    }

    /**
     * 更新成语审核状态
     *
     * @param word
     * @param state
     * @return
     */
    @Override
    public int updateIdiomCheckState(String word, Integer state) throws Exception {
        Idiom idiom = idiomMapper.selectByWord(word);
        if(idiom == null){
            throw new DataNotExitException();
        }
        Date updatetime = new Date();
        int flag = idiomMapper.updateCheckState(word,state, updatetime);
        if(flag == 0) {
            throw new FailException("成语审核状态更新失败");
        }

        return flag;
    }


}
