package com.cn.iscp.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.cn.common._Const;
import com.cn.unit.utils.DateUtil;

public class SessionInterceptor implements HandlerInterceptor {
	
	private static final String ERROR_URL = "/iscp/main/error";
	private static final String[] IGNORE_URI = {"/main/", "/apk/", "/sms/", "/mt/", "/mobile/", "/view", ".", "/upload"};
	
	/**
	 * 执行Handler完成执行此方法 
	 * 应用场景：统一异常处理，统一日志处理 
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}
	
	/**
	 * 进入Handler方法之后，返回modelAndView之前执行
	 * 应用场景从modelAndView出发：将公用的模型数据(比如菜单导航)在这里
	 * 传到视图，也可以在这里统一指定视图 
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
	}
	
	/**
	 * 执行Handler方法之前执行
	 * 用于身份认证、身份授权
	 * 比如身份认证，如果认证通过表示当前用户没有登陆，需要此方法拦截不再向下执行 
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object object) throws Exception {
		// 获取请求的url
        String url = request.getServletPath();
        System.out.println("访问日志："+DateUtil.getStrByDate(null, null)+"\t"+url);
        
        HttpSession session = request.getSession(true);
        
        // 404错误
        if(url.indexOf("/main/404") >= 0){
			response.setContentType("text/html;charset=UTF-8");
			session.setAttribute(_Const.SESSIONNAME_ERRORCODE, 404);
			PrintWriter out = response.getWriter();
			out.println("<script>window.parent.location='"+ERROR_URL+"';</script>");
			return false;
        }
        
        // 手机控制器跳过验证
        boolean flag = false;
        for (String item : IGNORE_URI) {
        	if (url.contains(item)) {
        	    flag = true;
        	    break;
        	}
        }
        if(flag){
        	return true;
        }
        
		/*session.setAttribute(Const.SESSIONNAME_LOGINUSERID, 29);
		session.setAttribute(Const.SESSIONNAME_LOGINUSERACCOUNT, "13679797665");*/
		
        /*if(!Tool.isEmpty(catalogCode)){
            session.setAttribute(Const.SESSIONNAME_CATALOGCODE, catalogCode);
        }*/
        // 500错误或session已过期
		if(url.indexOf("/main/500")>=0 || session.getAttribute(_Const.SESSIONNAME_LOGINUSERID) == null){
			response.setContentType("text/html;charset=UTF-8");
			session.setAttribute(_Const.SESSIONNAME_ERRORCODE, 500);
			PrintWriter out = response.getWriter();
			out.println("<script>window.parent.location='"+ERROR_URL+"';</script>");
			return false;
		}
		return true;
	}
	
}
