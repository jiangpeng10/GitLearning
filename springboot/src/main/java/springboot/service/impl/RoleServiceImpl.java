package springboot.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.entity.Resource;
import springboot.entity.Roleinfo;
import springboot.mapper.ResourceMapper;
import springboot.mapper.RoleinfoMapper;
import springboot.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleinfoMapper roleinfoMapper;
	@Autowired
	private ResourceMapper resourceMapper;
	
	@Override
	public List<Roleinfo> findAllRole() {
		return roleinfoMapper.searchRoleinfoByParams(null);
	}

	@Override
	public int addRoleResource(int roleid, int resourceid) {
		int num = -1;
		//增加指定的角色和模块
		num = roleinfoMapper.insertroleresource(roleid, resourceid);
		//查询该模块的父模块ID
		//通过resourceid查询
		Map map = new HashMap();
		map.put("rid", resourceid);
		List<Resource> resource1 = resourceMapper.searchResourceByParams(map);
		System.out.println(resource1.size());
		int parentId = -1;
		if(resource1.size()==1){
			//查到resourceid的父级模块
			parentId = resource1.get(0).getParentId();
		}
		//查询roleresource中有没有roleid和parentId的模块
		map.put("roleid", roleid);
		map.put("resourceid", parentId);
		int count = -1;
		count = roleinfoMapper.searchRoleAndResourceByParams(roleid,parentId);
		//如果没有，则增加角色和父模块
		if(count==0){
			num+=roleinfoMapper.insertroleresource(roleid, parentId);
		}
		return num;
	}

	@Override
	public int deleteRoleResource(int roleid, int resourceid) {
		int relnum = -1;
		//查询角色是否有指定模块的同级模块
		int count = roleinfoMapper.searchCountRoleResource(roleid, resourceid);
		//如果没有，则删除角色和指定模块
		if(count<=1){
		//有则将父模块删除,先找到父模块id
			Map map = new HashMap();
			map.put("rid", resourceid);
			List<Resource> resource1 = resourceMapper.searchResourceByParams(map);
			int parentId = -1;
			if(resource1.size()==1){
				parentId = resource1.get(0).getParentId();
			}
			//在roleresource表中删除roleid和parentid
			relnum = roleinfoMapper.deleteroleresource(roleid, parentId);
		}
		relnum += roleinfoMapper.deleteroleresource(roleid, resourceid);
		return relnum;
	}

}
