package com.qianfeng.dao;

import com.qianfeng.entity.SysDepart;

public interface SysDepartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysDepart record);

    int insertSelective(SysDepart record);

    SysDepart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysDepart record);

    int updateByPrimaryKey(SysDepart record);
}