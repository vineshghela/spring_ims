package com.qa.utils;

import static org.springframework.beans.BeanUtils.copyProperties;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class SpringBeanUtil {

	public static void mergeNotNull(Object source, Object target) {
		copyProperties(source, target, getNullPropName(source));
	}

	private static String[] getNullPropName(Object src) {
		final BeanWrapper wrappedSrObj = new BeanWrapperImpl(src);
		Set<String> propertyName = new HashSet<>();
		for (PropertyDescriptor descriptor : wrappedSrObj.getPropertyDescriptors()) {
			if (wrappedSrObj.getPropertyValue(descriptor.getName()) == null)
				propertyName.add(descriptor.getName());

		}
		return propertyName.toArray(new String[propertyName.size()]);

	}

}
