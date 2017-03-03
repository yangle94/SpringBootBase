/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package cn.ylapl.mapper;

import cn.ylapl.entity.SeleniumInfo;
import cn.ylapl.util.MyBatis.SimpleSelectInExtendedLanguageDriver;
import cn.ylapl.util.MyBatis.SimpleUpdateExtendedLanguageDriver;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author yangle
 * @version $Id SeleniumInfoMapper.xml.java, v 0.1 2017-01-22 下午3:50 yangle Exp $$
 */
@Mapper
public interface SeleniumInfoMapper {

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "info", column = "info"),
            @Result(property = "ip", column = "ip"),
            @Result(property = "createDate", column = "createDate")
    })
    @Select("SELECT * FROM selenium_info WHERE id = #{id}")
    SeleniumInfo findById(@Param("id") Integer id);

    @Insert("Insert into selenium_info(id,info,ip,createDate) VALUES (#{id},#{info},#{ip},#{createDate})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(SeleniumInfo seleniumInfo);

    @Delete("DELETE from selenium_info WHERE id=#{id}")
    int deleteById(@Param("id")Integer id);

    @Update("UPDATE selenium_info SET (id = #{id},info = #{info},ip = #{ip},createDate = #{createDate}) WHERE id=#{id}")
    @Lang(SimpleUpdateExtendedLanguageDriver.class)
    int updateById(SeleniumInfo seleniumInfo);


    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "info", column = "info"),
            @Result(property = "ip", column = "ip"),
            @Result(property = "createDate", column = "createDate")
    })
    @Select("SELECT * FROM selenium_info WHERE id IN (#{ids})")
    @Lang(SimpleSelectInExtendedLanguageDriver.class)
    List<SeleniumInfo> findListInIds(@Param("ids")List<Integer> ids);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "info", column = "info"),
            @Result(property = "ip", column = "ip"),
            @Result(property = "createDate", column = "createDate")
    })
    @Select("SELECT * FROM selenium_info")
    @Lang(SimpleSelectInExtendedLanguageDriver.class)
    List<SeleniumInfo> findAll();

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "info", column = "info"),
            @Result(property = "ip", column = "ip"),
            @Result(property = "createDate", column = "createDate")
    })
    @Select("SELECT * FROM selenium_info ORDER BY id DESC LIMIT 1")
    @Lang(SimpleSelectInExtendedLanguageDriver.class)
    SeleniumInfo findLast();
}