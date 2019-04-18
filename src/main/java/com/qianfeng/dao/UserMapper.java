package com.qianfeng.dao;

import com.qianfeng.entity.User;
import com.qianfeng.vo.VMenuInfo;
import com.qianfeng.vo.VUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    public int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    public String findPwdByName(String name);

    public List<VMenuInfo> findMenu(String no);

    public User findByNo(String name);

    public List<VUser> findUserAll(@Param("no") String no,@Param("flag") Integer flag);

    public void delById(@Param("flag")int flag,@Param("id")int id);

    public List<VUser> findrole(Integer id);

    public void updateStatus(@Param("flag")int flag,@Param("id")int id);

    public void updateName(@Param("name")String name,@Param("id")int id1);

    public int findUserId(int id);

    public  List<User> findLeaders(int id);
}