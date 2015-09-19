package com.hy.manager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hy.manager.domain.AbstractMapper;
import com.hy.manager.domain.Menu;
import com.hy.manager.domain.MenuMapper;

@Service
public class MenuService extends AbstractService<Menu> {

	@Autowired
	private MenuMapper menuMapper;

	public MenuService() {
		super(Menu.class);
	}

	@Override
	public AbstractMapper getAbstractMapper() {
		return menuMapper;
	}

	/**
	 * 获得有权限的菜单
	 * 
	 * @param userId
	 * @return
	 */
	public List<Menu> findPermissionMenu(int userId) {
		List<Menu> menus = this.menuMapper.findPermissionMenu(userId);
		List<Menu> list = this.recursionMenu(menus, 0);
		return list;
	}

	private List<Menu> recursionMenu(List<Menu> menus, int parentId) {
		List<Menu> list = new ArrayList<Menu>();
		for (Menu menu : menus) {
			if (menu.getParentId() == parentId) {
				List<Menu> children = this.recursionMenu(menus, menu.getId());
				menu.setChildren(children);
				list.add(menu);
			}
		}
		return list;
	}

}
