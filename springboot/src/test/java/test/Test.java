package test;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.wx.entity.QrCode;
import com.wx.service.QrCodeService;

import springboot.Hello;
import springboot.entity.Resource;
import springboot.entity.Userinfo;
import springboot.mapper.ResourceMapper;
import springboot.mapper.UserinfoMapper;
import springboot.service.UserinfoService;

@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！ 
@SpringBootTest(classes = Hello.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration
public class Test {
	@Autowired
	private UserinfoService userinfoServiceImpl;
	@Autowired
	private ResourceMapper resourceMapper;
	@Autowired
	private UserinfoMapper userinfoMapper;
	@Autowired
	private QrCodeService qrCodeServiceImpl;
	
	/**
	 * 测试获取二维码ticket
	 */
	@org.junit.Test
	public void getQrCode(){
			QrCode code= qrCodeServiceImpl.getQrCodeTicket();
			System.out.println(code.getSequence()+"==>ticket:"+code.getTicket());
	}
	
	
	@org.junit.Test
	public void start(){
		Userinfo user = new Userinfo();
		user.setUname("ljp");
		user.setUpass("123456");
		user = userinfoServiceImpl.userLogin(user);
		System.out.println(user);
	}
	
	@org.junit.Test
	public void findAll(){
		List<Userinfo> list = userinfoServiceImpl.findAll();
		System.out.println(list.size());
	}
	
	@org.junit.Test
	public void findResource(){
		List<Resource> list = resourceMapper.searchResourceByUserId(1);
		System.out.println(list.size());
	}
	//查询2号用户的模块的权限
	@org.junit.Test
	public void testauth(){
		Map<String, String> map= userinfoServiceImpl.findUserAuth(1);
		Set<Entry<String, String>> set = map.entrySet();
		for (Entry<String, String> entry : set) {
			System.out.println(entry.getKey()+"===>"+entry.getValue());
		}
	}
	//修改用户状态
	@org.junit.Test
	public void changeustatus(){
		Userinfo userinfo = new Userinfo();
		userinfo.setUid(2);
		userinfo.setUstatus("0");
		userinfoServiceImpl.changeustatus(userinfo);
	}
	
	//给用户添加或者删除角色
	@org.junit.Test
	public void changeuserandrole(){
		 userinfoServiceImpl.changerole(1, 3, "false");
	}
	
	//测试resourceMapper的加了一条权值
	@org.junit.Test
	public void testresourceMapperauth(){
		List<Resource> list = resourceMapper.searchResourceByRoleId(3);
		for (Resource resource : list) {
			System.out.println(resource.getRid()+"==>资源名称： "+resource.getRname()+"==>资源权值："+resource.getAuthority());
		}
	}
	
	@org.junit.Test
	public void TestRoleAndAuth(){
		List<Resource> userresource = resourceMapper.searchResourceByRoleId(5);
		for (Resource resource : userresource) {
			System.out.println(resource);
		}
	}
}
