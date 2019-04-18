package com.qianfeng.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianfeng.dao.RoleMapper;
import com.qianfeng.dao.UserMapper;
import com.qianfeng.entity.Role;
import com.qianfeng.entity.User;
import com.qianfeng.service.RoleService;
import com.qianfeng.vo.VUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.*;

/**
 * Created by Administrator on 2019/4/15.
 */
@Controller
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleMapper roleDao;
    @Autowired
    private UserMapper userDao;

    @Override
    public Map<String, Object> findUserAll(int page, int limit, String no, Integer flag) {
        PageHelper.startPage(page,limit);
        List<Role> list = roleDao.findRoleAll(no,flag);
        // 获取总条数
        long total = ((Page)list).getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("count", total);// 总条数
        map.put("data", list); // 当前页显示的记录
        map.put("code",0);
        map.put("mag","");
        return map;
    }

    @Override
    public void delById(int id) {
        int flag = 2;
        roleDao.delById(flag,id);
        roleDao.delByRId(flag,id);
    }

    @Override
    public void updateAu(int id, int[] rids) {

        roleDao.deleteAu(id);
        if(rids.length != 0 ){
            for (int i = 0; i < rids.length ; i++) {
                int [] array =  roleDao.findAu(rids[i]);
                roleDao.addAu(id,rids[i],array);
            }
        }

    }

    @Override
    public Collection<User> findRole1(int id) {
        List <Role> listLeadersId =  roleDao.findMyRole(id);
        List<User>  userMe = null;
        for (int i = 0; i < listLeadersId.size(); i++){
            if (listLeadersId.get(i).getParentid() == 0){
                userMe = userDao.findLeaders(2);
            }

        }
        for (int i = 0; i < listLeadersId.size(); i++){
            if (userMe.get(i).getId() == id){
                userMe.remove(userMe.get(i));
                return userMe;
            }
        }


        Set<User> list = new HashSet<>();
        for (int i = 0; i < listLeadersId.size(); i++){

            try {
                List<User>  userList = userDao.findLeaders(listLeadersId.get(i).getParentid());
                if (userList.get(i).getId() == id){
                    userList.remove(userList.get(i));
                }
                list.addAll(userList);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return list;
    }
}
