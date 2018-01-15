package springboot.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import springboot.entity.Roleinfo;
import com.fc.platform.commons.page.Page;
import com.fc.platform.commons.page.Pageable;

public interface RoleinfoMapper {

	void insertRoleinfo(Roleinfo roleinfo);

	void deleteRoleinfoByRid(Integer rid);

	void updateRoleinfo(Roleinfo roleinfo);

	Page<Roleinfo> searchRoleinfoByParams(@Param("map")Map<String, String> map , Pageable pageable);

	List<Roleinfo> searchRoleinfoByParams(@Param("map")Map<String, String> map);

	int insertroleresource(@Param("roleid")Integer roleid,@Param("resourceid")Integer resourceid);
	
	int deleteroleresource(@Param("roleid")Integer roleid,@Param("resourceid")Integer resourceid);
	
	int searchCountRoleResource(@Param("roleid")Integer roleid,@Param("resourceid")Integer resourceid);

	int searchRoleAndResourceByParams(@Param("roleid")Integer roleid,@Param("resourceid")Integer resourceid);
} 
