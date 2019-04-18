package com.qianfeng.service;

import com.qianfeng.entity.Authority;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/4/15.
 */
public interface AuthorityService {
    public Map<String, Object> findAuthorityAll(int page, int limit);

    public List findAu(int id);

    public void deleteByAid(int id);

    public List findAuYIJi();

    public int insertSelective(Authority record);
}
