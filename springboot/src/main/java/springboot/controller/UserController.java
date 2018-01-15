package springboot.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fc.platform.commons.page.Page;

import springboot.entity.Userinfo;
import springboot.service.UserinfoService;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserinfoService userinfoServiceImpl;
	
	@RequestMapping("changestatus")
	@ResponseBody
	public Object changestatus(Integer uid,String ustatus){
		Map<String,String> response = new HashMap<String,String>();
		Userinfo userinfo = new Userinfo();
		userinfo.setUid(uid);
		ustatus=ustatus.equals("true")?"1":"0";
		System.out.println(ustatus);
		userinfo.setUstatus(ustatus);
		userinfoServiceImpl.changeustatus(userinfo);
		response.put("msg", "ok");
		return response;
	}
	
	@RequestMapping("changerole")
	@ResponseBody
	public Object changerole(Integer uid,Integer rid,String rolecheck){
		Map<String,String> response = new HashMap<String,String>();
		userinfoServiceImpl.changerole(uid,rid,rolecheck);
		response.put("msg", "over");
		return response;
	}
	
	@RequestMapping("searchuser")
	@ResponseBody
	public Object searchuser(String uname){
		Map<String,Object> response = new HashMap<String, Object>();
		List<Userinfo> list = userinfoServiceImpl.findUserByName(uname);
		response.put("code", 0);
		response.put("msg", "ok");
		response.put("count", list.size());
		response.put("data", list);	
		return response;
	}
	
	@RequestMapping("userlogin")
	@ResponseBody
	public Object userlogin(Userinfo userinfo,HttpSession session){
		Map<String,String> response = new HashMap<String,String>();
		Userinfo user =  userinfoServiceImpl.userLogin(userinfo);
		if(user!=null){
			response.put("msg", "ok");
		}else{
			response.put("msg", "用户名或密码错误！");
		}
		Map<String,String> map = userinfoServiceImpl.findUserAuth(userinfo.getUid());
		user.setUserauth(map);
		session.setAttribute("user", user);
		return response;
	}
	
	@RequestMapping("out")
	@ResponseBody
	public void loginout(HttpServletResponse response){
		try {
			response.sendRedirect("/Wopop.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("userlist")
	@ResponseBody
	public Object userlist(){
		return userinfoServiceImpl.findAll();
	}
	
	@RequestMapping("userlistdatabypage")
	@ResponseBody
	public Object userlistbypage(Userinfo map, @RequestParam(value="page",defaultValue="1") int page,
			@RequestParam(value="limit",defaultValue="5") int limit){
		page--;
		Page<Userinfo> pagedata = userinfoServiceImpl.findallUserAndRole(map, page, limit);
		Map<String,Object> response = new HashMap<String, Object>();
		response.put("code", 0);
		response.put("msg", "ok");
		response.put("count", pagedata.getTotalElements());
		response.put("data", pagedata.getContent());	
		return response;
	}
	
	
}
