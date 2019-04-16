package com.qianfeng.dao;

import com.qianfeng.entity.Check;
import com.qianfeng.entity.User;

import java.util.List;

public interface CheckMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Check record);

    public int insertSelective(Check record);

    public Check selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Check record);

    int updateByPrimaryKey(Check record);

    public List<Check> findCheckAll(String name);

    public List<User> findRanme(String name);

    public void del(int id);


}