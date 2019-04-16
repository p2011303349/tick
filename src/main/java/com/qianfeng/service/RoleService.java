package com.qianfeng.service;



import java.util.Map;

/**
 * Created by Administrator on 2019/4/14.
 */
public interface RoleService {
    public Map<String,Object> findUserAll(int page, int limit, String no, Integer flag);
    public void delById(int id);

}
