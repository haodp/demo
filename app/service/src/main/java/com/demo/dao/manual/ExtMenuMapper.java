package com.demo.dao.manual;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.dao.manual.entity.ExtMenu;

public interface ExtMenuMapper {

    /**
     * 查询Menu Tree画面一览
     */
    List<ExtMenu> selectMenuTree(@Param("userId") String userId);

}