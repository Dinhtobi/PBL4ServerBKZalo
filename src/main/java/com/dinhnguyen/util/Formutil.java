package com.dinhnguyen.util;



import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
;

public class Formutil {
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static <T> T toUsers(Class<T> tClass, HttpServletRequest req) {
		T object = null;
		try {
			object = tClass.newInstance();
			BeanUtils.populate(object, req.getParameterMap());
		} catch (InstantiationException  | IllegalAccessException  |InvocationTargetException e) {
			System.out.print(e.getMessage());
		} 
		return object;
	}
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static <T> T toAdmin(Class<T> tClass, HttpServletRequest req) {
		T object = null;
		try {
			object = tClass.newInstance();
			BeanUtils.populate(object, req.getParameterMap());
		} catch (InstantiationException  | IllegalAccessException  |InvocationTargetException e) {
			System.out.print(e.getMessage());
		} 
		return object;
	}
}
