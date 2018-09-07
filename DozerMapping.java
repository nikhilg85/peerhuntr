package com.infodart.peerhuntr.mapper;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;


public class DozerMapping {

	
	
	public static Object convert(Object sourceObject,Object destObject,Class clazz) {
		Mapper mapper = new DozerBeanMapper();
		destObject  = mapper.map(sourceObject,clazz);
		return destObject;
	}

	
	
	
	
}
