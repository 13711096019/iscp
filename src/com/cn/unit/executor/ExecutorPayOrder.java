package com.cn.unit.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import com.cn.iscp.entity.pay.ChargeOrder;
import com.cn.iscp.service.pay.impl.ChargeOrderServiceImpl;
import com.cn.unit.frame.SpringBeanFactoryUtil;

/**
 * 添加缴费工单线程池
 */
public class ExecutorPayOrder {
	
	private static Logger log = Logger.getLogger(ExecutorPayOrder.class);
	private ExecutorService executor = Executors.newFixedThreadPool(1);
	
	// 工单对象
	private ChargeOrder order;
	
	
	public ExecutorPayOrder(ChargeOrder order){
		this.order = order;
	}
	
	public void asynTask() throws InterruptedException {
        executor.submit(new Runnable() {
            @Override
            public void run() {
            	log.info("开始 添加缴费工单线程");
            	ChargeOrderServiceImpl chargeOrderService = (ChargeOrderServiceImpl) SpringBeanFactoryUtil.getBean("chargeOrderService");
            	chargeOrderService.insertOrder(getChargeOrder());
            	log.info("结束 添加缴费工单线程");
            }
        });
    }

	public ChargeOrder getChargeOrder() {
		return order;
	}
	public void setChargeOrder(ChargeOrder order) {
		this.order = order;
	}
	
}
