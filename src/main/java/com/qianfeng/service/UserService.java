package com.qianfeng.service;

import com.qianfeng.entity.User;
import com.qianfeng.vo.VMenuInfo;
import com.qianfeng.vo.VUser;
import org.apache.shiro.web.session.HttpServletSession;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/4/13.
 */
public interface UserService {
    public User findByNo(String name);
    public void login(String name, String password);
    public List<VMenuInfo> findMenu(String no);

    public Map<String,Object> findUserAll(int page,int limit,String no,Integer flag);

    public void delById(int id);

    public List<VUser> findrole(Integer id);

    public void updateStatus(int id,int rids,String name);


}
