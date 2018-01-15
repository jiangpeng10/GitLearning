package springboot.service;

import java.util.List;

import springboot.entity.Resource;
import springboot.entity.Roleinfo;

public interface RoleService {
	public List<Roleinfo> findAllRole();
	
	public int addRoleResource(int roleid,int resourceid);
	
	public int deleteRoleResource(int roleid,int resourceid);
}
