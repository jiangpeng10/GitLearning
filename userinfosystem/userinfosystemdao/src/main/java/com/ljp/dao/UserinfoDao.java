package com.ljp.dao;

import com.ljp.domain.Userinfo;

import java.util.List;

public interface UserinfoDao {
    /**
     * 新增用户信息
     * @param userinfo
     * @return 受影响的行数
     */
    int insertUserinfo(Userinfo userinfo);

    /**
     * 通过用户Id查询用户信息
     * @param userId
     * @return
     */
    List<Userinfo> searchUserinfo(Integer userId);
}
