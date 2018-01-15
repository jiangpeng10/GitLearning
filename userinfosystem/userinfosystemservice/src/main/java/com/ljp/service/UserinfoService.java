package com.ljp.service;

import com.ljp.domain.Userinfo;

import java.util.List;

public interface UserinfoService {
    /**
     * 插入员工
     * @param userinfo
     * @return
     */
    int insertUser(Userinfo userinfo);

    /**
     * 通过userId查询用户信息
     * @param userId
     * @return
     */
    List<Userinfo> searchUserinfo(Integer userId);
}
