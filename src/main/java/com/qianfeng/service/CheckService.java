package com.qianfeng.service;

import com.qianfeng.entity.Check;
import com.qianfeng.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/4/15.
 */
public interface CheckService {
    public Map<String,Object> findCheckAll(int page,int limit,String name);

    public int insertSelective(Check record);

    public List<User> findRanme(String name);

    public void del(int id);

    public Map<String,Object> findCheckAll1(int page,int limit,String name);

    public void  updateFalg(int id,int flag);
}
