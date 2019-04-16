package com.qianfeng.dao;

import com.qianfeng.entity.Authority;
import com.qianfeng.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthorityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Authority record);

    int insertSelective(Authority record);

    Authority selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Authority record);

    int updateByPrimaryKey(Authority record);

    public List<Authority> findAuthorityAll();

    public List<Authority> findAu(Integer id);

    public List<Authority> findAll();




}