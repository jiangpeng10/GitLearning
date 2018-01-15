package springboot.service;

import java.util.List;

import springboot.entity.Resource;
import springboot.vo.ResourceVo;

public interface ResourceService {
	public List<Resource> loadResourceByUserId(int userid);

	public List<ResourceVo> loadAllResourceVoByRoleId(int rid);
	
	public List<Resource> findAllResource();
}
