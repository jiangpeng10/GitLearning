package springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import springboot.service.ResourceService;
import springboot.vo.PageVo;
import springboot.vo.ResourceVo;

@Controller
public class ResourceController{
	
	@Autowired
	private ResourceService resourceServiceImpl;
	
	@RequestMapping("findAllResource")
	@ResponseBody
	public PageVo<ResourceVo> findAllResource(int roleid){
		System.out.println("页面传过来的roleid是："+roleid);
		PageVo<ResourceVo> vo = new PageVo<ResourceVo>();
		List<ResourceVo> list = resourceServiceImpl.loadAllResourceVoByRoleId(roleid);
		vo.setCode(0);
		vo.setCount(list.size());
		vo.setMsg("ok");
		vo.setData(list);
		return vo;
	}
	
	
}
