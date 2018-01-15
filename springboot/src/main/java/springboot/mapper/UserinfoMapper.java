package springboot.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import springboot.entity.Userinfo;
import com.fc.platform.commons.page.Page;
import com.fc.platform.commons.page.Pageable;

public interface UserinfoMapper {

	void insertUserinfo(Userinfo userinfo);

	void deleteUserinfoByUid(Integer uid);

	void updateUserinfo(Userinfo userinfo);

	Page<Userinfo> searchUserinfoByParams(@Param("map")Map<String, String> map , Pageable pageable);

	List<Userinfo> searchUserinfoByParams(@Param("map")Map<String, String> map);

	/**
	 * 查询用户拥有的模块的权限
	 */
	public List<Map<String,String>> searchUserAuth(@Param("uid") Integer uid);
	/**
	 * 查询用户所拥有的角色信息
	 * @param map
	 * @param pageable
	 * @return
	 */
	Page<Userinfo> searchUserAndRoleByParams(@Param("map")Userinfo map , Pageable pageable);
	//增加user和role的关系
	void insertUserAndRole(@Param("uid") Integer uid,@Param("rid") Integer rid);
	//删除user和role的关系
	void deleteUserAndRole(@Param("uid") Integer uid,@Param("rid") Integer rid);

	List<Userinfo> searchUserinfoByUname(@Param("uname") String uname);

	
} 
