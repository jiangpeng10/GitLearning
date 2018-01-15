package springboot.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private CheckAuthInterceptor checkAuthInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(checkAuthInterceptor).addPathPatterns("/**").excludePathPatterns("/main","/user/userlogin");
		super.addInterceptors(registry);
	}
	
	
}
