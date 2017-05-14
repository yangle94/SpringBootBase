package cn.ylapl.dao.Impl;

import cn.ylapl.dao.SeleniumInfoDao;
import cn.ylapl.entity.SeleniumInfo;
import cn.ylapl.mapper.SeleniumInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author yangle
 * @version $Id SeleniumInfoDaoImpl.java, v 0.1 2017-01-22 下午4:45 yangle Exp $$
 */
@Repository
public class SeleniumInfoDaoImpl implements SeleniumInfoDao {

    private final SeleniumInfoMapper seleniumInfoMapper;

    private static final Logger logger = LoggerFactory.getLogger(SeleniumInfoDaoImpl.class);

    SeleniumInfoDaoImpl(@Autowired SeleniumInfoMapper seleniumInfoMapper) {
        this.seleniumInfoMapper = seleniumInfoMapper;
    }

    @Override
    public SeleniumInfo getSeleniumInfo(int id) {
        logger.info("id:{}", id);
        return seleniumInfoMapper.findById(id);
    }

    @Override
    public List<SeleniumInfo> getSeleniumInfoList(List<Integer> ids) {
        logger.info("idsSize:{}", ids.size());
        return seleniumInfoMapper.findListInIds(ids);
    }

    @Override
    public int insertSeleniumInfo(SeleniumInfo seleniumInfo) {
        logger.info("id:{}", seleniumInfo.getId());
        return seleniumInfoMapper.insert(seleniumInfo);
    }

    @Override
    public int deleteSeleniumInfo(SeleniumInfo seleniumInfo) {
        logger.info("id:{}", seleniumInfo.getId());
        return seleniumInfoMapper.deleteById(seleniumInfo.getId());
    }

    @Override
    public int updateSeleniumInfo(SeleniumInfo seleniumInfo) {
        logger.info("id:{}", seleniumInfo.getId());
        return seleniumInfoMapper.updateById(seleniumInfo);
    }

    @Override
    public List<SeleniumInfo> findAll() {
        logger.info("findAll");
        return seleniumInfoMapper.findAll();
    }

    @Override
    public SeleniumInfo findLast() {
        logger.info("findAll");
        return seleniumInfoMapper.findLast();
    }
}