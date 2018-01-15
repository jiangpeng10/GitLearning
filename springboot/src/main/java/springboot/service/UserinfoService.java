package springboot.service;

import java.util.List;
import java.util.Map;

import com.fc.platform.commons.page.Page;

import springboot.entity.Userinfo;

public interface UserinfoService {
	public Userinfo userLogin(Userinfo user);
	public List<Userinfo> findAll();
	public Page<Userinfo> findAll(int page,int limit);
	//查询用户的权限
	public Map<String,String> findUserAuth(Integer uid);
	//分页查询用户信息，为了显示所有用户和角色
	public Page<Userinfo> findallUserAndRole(Userinfo condition,int page,int limit);
	//修改用户的状态
	public void changeustatus(Userinfo userinfo);
	public void changerole(Integer uid, Integer rid, String rolecheck);
	public List<Userinfo> findUserByName(String uname);  
}
