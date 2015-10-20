package com.hy.manager.job;

import org.springframework.context.ApplicationContextAware;

import com.hy.manager.service.business.SkuService;
/**
 * @author lianghongl
 * 定时刷新每个SKU的评分情况
 */
public class UpdateSkuScoreJob extends AbstractJob implements ApplicationContextAware{
	private SkuService skuService;
	protected void execute() {
		skuService = (SkuService) applicationContext.getBean("skuService");
		System.out.println("执行SKU定时任务");
		skuService.updateSkuScore();
	}

}