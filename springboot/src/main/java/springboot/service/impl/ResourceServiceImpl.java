package springboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.entity.Resource;
import springboot.mapper.ResourceMapper;
import springboot.service.ResourceService;
import springboot.vo.ResourceVo;
@Service
@Transactional
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	private ResourceMapper resourceMapper;
	
	@Override
	public List<Resource> loadResourceByUserId(int userid) {
		// TODO Auto-generated method stub
		return resourceMapper.searchResourceByUserId(userid);
	}
	
	@Override
	public List<Resource> findAllResource(){
		 List<Resource> allresource =  resourceMapper.searchResourceByParams(null);
		 return allresource;
	}
	
	@Override
	public List<ResourceVo> loadAllResourceVoByRoleId(int roleid) {
		//查询所有模块
		List<Resource> allresource =  resourceMapper.searchResourceByParams(null);
		//查询roleresource表中传入roleid查到的resourceid,再根据该resourceid查resource表
		List<Resource> userresource = resourceMapper.searchResourceByRoleId(roleid);
		//new一个ResourceVo用来存放有权限的资源
		List<ResourceVo> newresource = new ArrayList<ResourceVo>();
		for (Resource resource : allresource) {
			ResourceVo resvo = new ResourceVo();
			resvo.setRid(resource.getRid());
			resvo.setResorderno(resource.getResorderno());
			resvo.setResurl(resource.getResurl());
			resvo.setRname(resource.getRname());
			resvo.setParentId(resource.getParentId());
			for (Resource ur : userresource) {
				if(ur.getRid()==resource.getRid()){
					resvo.setSelect(1);
			}
				if(ur.getAuthority().contains("insert")){
					resvo.setInsert(1);
				}
				if(ur.getAuthority().contains("delete")){
					resvo.setDelete(1);
				}
				if(ur.getAuthority().contains("update")){
					resvo.setUpdate(1);
				}
			}
			newresource.add(resvo);
		}
		return newresource;
	}
}
