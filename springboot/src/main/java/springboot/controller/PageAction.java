package springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageAction{
	@RequestMapping("page_{url}")
	public String page(@PathVariable("url") String url){
		System.out.println("进入到pageAction中"+url);
		return url;
	}
}
