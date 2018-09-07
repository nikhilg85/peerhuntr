package com.infodart.peerhuntr.jpa.dao.impl.basedao;

import com.googlecode.genericdao.search.Search;

public class BaseSearch extends Search {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Class clazz;
	public BaseSearch(Class clazz) {
		super();
		this.clazz = clazz;
	}

}
