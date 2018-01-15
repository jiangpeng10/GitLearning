package com.ljp.service.impl;

import com.ljp.dao.UserinfoDao;
import com.ljp.domain.Userinfo;
import com.ljp.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserinfoServiceImpl implements UserinfoService {

    @Autowired
    private UserinfoDao userinfoDao;

    @Override
    public int insertUser(Userinfo userinfo) {
        return userinfoDao.insertUserinfo(userinfo);
    }

    @Override
    public List<Userinfo> searchUserinfo(Integer userId) {
        return userinfoDao.searchUserinfo(userId);
    }
}
