package com.qianfeng.service;



import com.qianfeng.entity.Role;
import com.qianfeng.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/4/14.
 */
public interface RoleService {
    public Map<String,Object> findUserAll(int page, int limit, String no, Integer flag);
    public void delById(int id);
    public void updateAu(int id,int[] rids);
    public Collection<User> findRole1(int id);

}
