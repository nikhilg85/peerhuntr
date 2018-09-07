package com.infodart.peerhuntr.jpa.dao.impl.basedao;

public class BaseSearchBeanLookup {
	
	public static BaseSearch getPosSearchBeanInstance(Class clazz)
	{
		return new BaseSearch(clazz);
	}
}
