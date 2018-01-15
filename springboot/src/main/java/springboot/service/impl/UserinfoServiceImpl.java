package springboot.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fc.platform.commons.page.Page;
import com.fc.platform.commons.page.PageRequest;

import springboot.entity.Roleinfo;
import springboot.entity.Userinfo;
import springboot.mapper.RoleinfoMapper;
import springboot.mapper.UserinfoMapper;
import springboot.service.ResourceService;
import springboot.service.UserinfoService;

@Service
@Transactional
public class UserinfoServiceImpl implements UserinfoService{

	@Autowired
	private UserinfoMapper userinfoMapper;
	@Autowired
	private RoleinfoMapper roleinfoMapper;
	@Autowired
	private ResourceService resourceServiceImpl;
	
	@Override
	public Userinfo userLogin(Userinfo user) {
		Map<String, String> map = new HashMap<String,String>();
		map.put("uname", user.getUname());
		map.put("upass", user.getUpass());
		List<Userinfo> list = userinfoMapper.searchUserinfoByParams(map);
		if(list.size()==0){
			return null;
		}else{
			return list.get(0);
		}
	}

	@Override
	public List<Userinfo> findAll() {
		return userinfoMapper.searchUserinfoByParams(null);
	}

	@Override
	public Page<Userinfo> findAll(int page, int limit) {
		PageRequest pageable = new PageRequest(page,limit);
		return userinfoMapper.searchUserinfoByParams(null, pageable);
	}

	@Override
	public Map<String, String> findUserAuth(Integer uid) {
		// 从数据库拿到数据
		List<Map<String, String>> au = userinfoMapper.searchUserAuth(uid);
/*		for (Map<String, String> map : au) {System.out.println(map);}*/
		//合并authentic
		for (int i = au.size()-1; i > 0; i--) {
			Map<String,String> a = au.get(i);//拿到外层的数据
			for (int j = au.size()-1; j >=0; j--) {
				if(i!=j){//避免自己和自己比较，接下去合并数据
					Map<String,String> b = au.get(j);//拿到内层的数据
					//如果两个的url相等则合并authority列
					if(a.get("resurl")==b.get("resurl")){
						String aauth = a.get("authority");
						String bauth = b.get("authority");
						b.put("authority", aauth+","+bauth);//合并后数据放入内层
						au.remove(i);//将外层数据删除
					}
				}
			}
		}
		//合并后把list的数据放入map集合里
		Map<String, String> mapdata = new HashMap<String, String>();
		for (int i = 0;i<au.size();i++) {
			mapdata.put(au.get(i).get("resurl"), au.get(i).get("authority"));
		}
		return mapdata;
	}

	@Override
	public Page<Userinfo> findallUserAndRole(Userinfo map, int page, int limit) {
		PageRequest pageable = new PageRequest(page, limit);
		Page<Userinfo> data = userinfoMapper.searchUserAndRoleByParams(map, pageable);//拿到用户和角色信息
		List<Roleinfo> rols = roleinfoMapper.searchRoleinfoByParams(null);//拿到所有的角色
		for (Userinfo us : data.getContent()) {
			//查询所有的角色列表
			List<Roleinfo> hasrole = us.getRolelist();//拿到用户已有的角色
			ArrayList<Roleinfo> newrolelist = new ArrayList<Roleinfo>();
			for(int i = 0;i<rols.size();i++){
				Roleinfo r = new Roleinfo();
				r.setRid(rols.get(i).getRid());
				r.setRname(rols.get(i).getRname());
				for(int j=0;j<hasrole.size();j++){
					if(rols.get(i).getRid()==hasrole.get(j).getRid()){
						r.setFlag(1);
					}
				}
				newrolelist.add(r);
			}
			us.setRolelist(newrolelist);
		}
		 return data;
	}

	@Override
	public void changeustatus(Userinfo userinfo) {
		userinfoMapper.updateUserinfo(userinfo);
	}

	@Override
	public void changerole(Integer uid, Integer rid, String rolecheck) {
		// TODO Auto-generated method stub
		if(rolecheck.equals("false")){
			//删除urinfo里对应的uid和rid关系
			userinfoMapper.deleteUserAndRole(uid,rid);
		}else{
			////删除urinfo里对应的uid和rid关系
			userinfoMapper.insertUserAndRole(uid,rid);
		}
	}

	@Override
	public List<Userinfo> findUserByName(String uname) {
		List<Userinfo> list = userinfoMapper.searchUserinfoByUname(uname);
		return list;
	}
}
