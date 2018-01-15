package springboot.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import springboot.entity.Userinfo;

@Component
public class CheckAuthInterceptor implements HandlerInterceptor {
	
	/**
	 * 在请求之前调用
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		System.out.println("进入控制器前：拦截的地址是："+request.getRequestURI());
		Userinfo user = (Userinfo) request.getSession().getAttribute("user");
		if(user==null){
			response.sendRedirect("Wopop.jsp");
			return false;
		}
		return true;
	}
	
	/**
	 * 完成请求之后调用
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		

	}

	/**
	 * 请求之后，但在渲染之前调用
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	

}
