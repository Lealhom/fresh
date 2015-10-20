package com.hy.manager.job;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
public abstract class AbstractJob implements ApplicationContextAware{
	protected ApplicationContext applicationContext;
	protected abstract void execute();
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

}