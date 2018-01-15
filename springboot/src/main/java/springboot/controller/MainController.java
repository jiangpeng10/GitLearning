package springboot.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springboot.entity.Resource;
import springboot.entity.Userinfo;
import springboot.service.ResourceService;

@Controller
public class MainController {
	@Autowired
	private ResourceService resourceServiceImpl;
	
	@RequestMapping("main")
	public ModelAndView main(HttpSession session){
		Userinfo user = (Userinfo)session.getAttribute("user");
		Integer uid = user.getUid();
		List<Resource> resourcelist = resourceServiceImpl.loadResourceByUserId(uid);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("relist",resourcelist);
		
		return mv;
	}
}
