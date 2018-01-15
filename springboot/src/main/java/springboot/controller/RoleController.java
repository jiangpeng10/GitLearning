package springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import springboot.entity.Roleinfo;
import springboot.service.RoleService;
import springboot.vo.PageVo;

@Controller
public class RoleController{
	
	@Autowired
	private RoleService roleServiceImpl;
	
	@RequestMapping("findAllRole")
	@ResponseBody
	public PageVo<Roleinfo> findAllRole(){
		PageVo<Roleinfo> vo = new PageVo<Roleinfo>();
		List<Roleinfo> list = roleServiceImpl.findAllRole();
		vo.setCode(0);
		vo.setCount(list.size());
		vo.setMsg("ok");
		vo.setData(list);
		return vo;
	}
	
	@RequestMapping("updateroleresource")
	@ResponseBody
	public Object updateroleresource(int roleid,int resourceid,boolean flag ){
		System.out.println("=========roleid:"+roleid+"==>resourceid:"+resourceid+"==>flag:"+flag);
		int num = -1;
		if(flag){
			num = roleServiceImpl.addRoleResource(roleid, resourceid);
		}else{
			num = roleServiceImpl.deleteRoleResource(roleid, resourceid);
		}
		return num;
	}
}
