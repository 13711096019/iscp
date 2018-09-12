package com.cn.unit.frame;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.apache.log4j.Logger;

import com.cn.common._Const;
import com.cn.common._Tool;
import com.cn.iscp.service.ligent.impl.LoginLogServiceImpl;

/**
 * 自定义session监听器
 * @author 10011037@qq.com
 * 2016-09-20
 */
public class LoginSessionListener implements HttpSessionAttributeListener  {

	private static Logger log = Logger.getLogger(LoginSessionListener.class);
	
	/**
	 * 加入session时的监听方法.
	 */
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		if (_Const.SESSIONNAME_LOGINUSERID.equals(event.getName())) {
			log.info("加入session："+event.getValue());
			LoginLogServiceImpl loginLogService = (LoginLogServiceImpl) SpringBeanFactoryUtil.getBean("loginLogService");
			loginLogService.handleLoginLog(_Tool.toLong(event.getValue()), 1);
        }
	}
	
	/**
	 * session失效时的监听方法.
	 */
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		if (_Const.SESSIONNAME_LOGINUSERID.equals(event.getName())) {
			log.info("失效session："+event.getValue());
			LoginLogServiceImpl loginLogService = (LoginLogServiceImpl) SpringBeanFactoryUtil.getBean("loginLogService");
			loginLogService.handleLoginLog(_Tool.toLong(event.getValue()), 2);
        }
	}
	
	/**
	 * session覆盖时的监听方法.
	 */
	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}
    
}