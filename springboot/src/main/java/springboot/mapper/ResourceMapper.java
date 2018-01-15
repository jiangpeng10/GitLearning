package springboot.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import springboot.entity.Resource;
import com.fc.platform.commons.page.Page;
import com.fc.platform.commons.page.Pageable;

public interface ResourceMapper {

	void insertResource(Resource resource);

	void deleteResourceByRid(Integer rid);

	void updateResource(Resource resource);

	Page<Resource> searchResourceByParams(@Param("map")Map<String, String> map , Pageable pageable);

	List<Resource> searchResourceByParams(@Param("map")Map<String, String> map);
	/**
	 * 根据用户id查询他所具有的模块
	 * @param userid
	 * @return
	 */
	List<Resource> searchResourceByUserId(@Param("userid") int userid);
	/**
	 * 根据角色id查出该角色拥有的模块和权限
	 */
	List<Resource> searchResourceByRoleId(@Param("roleid") int roleid);
} 
