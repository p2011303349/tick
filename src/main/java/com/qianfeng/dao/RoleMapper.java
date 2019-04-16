package com.qianfeng.dao;

import com.qianfeng.entity.Role;
import com.qianfeng.vo.VUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    public List<Role> findRoleAll(@Param("no") String no, @Param("flag") Integer flag);

    public void delById(@Param("flag")int flag,@Param("id")int id);

    public void delByRId(@Param("flag")int flag,@Param("id")int id);

}