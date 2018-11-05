package org.bitbucket.evl;

import java.lang.invoke.MethodHandle;
import java.util.Map;

import org.bitbucket.evl.exception.MethodInsertionException;
import org.bitbucket.evl.util.CacheFactory;


public class Method1D<ReturnType, DataType> extends InvokableMethod1D<ReturnType, DataType> {
	
	// throws BadNumberOfVirtualParameterTypesException, BadNonVirtualParameterTypesException, MethodInsertionException
	public Method1D<ReturnType, DataType> add(Class<?> classInstance, String name, Class<?>[] parameterTypes, Object object, DataType data) {
		try {
			super.addMethod(classInstance.getMethod(name, parameterTypes), object, data);
		} catch (NoSuchMethodException | SecurityException e) {
			throw new MethodInsertionException();
		}
		return this;
	}
	
	// throws BadNumberOfVirtualParameterTypesException, BadNonVirtualParameterTypesException, MethodInsertionException
	public Method1D<ReturnType, DataType> add(Class<?> classInstance, String name, Class<?>[] parameterTypes, DataType data) {
		return add(classInstance, name, parameterTypes, null, data);
	}
	
	public Method1D<ReturnType, DataType> comparator(MethodComparatorD<DataType> methodComparator) {
		this.methodComparator = methodComparator;
		return this;
	}
	
	public Method1D<ReturnType, DataType> cache(Map<Class<?>, MethodHandle> cacheMap) {
		this.cache = cacheMap;
		return this;
	}
	
	public Method1D<ReturnType, DataType> unboundedCache() {
		this.cache = CacheFactory.<Class<?>, MethodHandle>createUnboundedCache();
		return this;
	}
	
	public Method1D<ReturnType, DataType> boundedCache(int capacity) {
		this.cache = CacheFactory.<Class<?>, MethodHandle>createBoundedCache(capacity);
		return this;
	}
}
