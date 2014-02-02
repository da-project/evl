package evl;

import java.util.AbstractMap;
import java.util.Arrays;

import evl.exceptions.EVLException;


public class Method2<ReturnType, DataType> extends MultiMethod<ReturnType, DataType> {
	
	public static class ClassTuple {
		
		private Class<?>[] tuple = new Class<?>[2];
		
		ClassTuple(Class<?> class1, Class<?> class2) {
			tuple[0] = class1;
			tuple[1] = class2;
		}
		
		@Override
		public int hashCode() {
			return Arrays.hashCode(tuple);
		}
		
		@Override
		public boolean equals(Object obj) {
			return Arrays.equals(tuple, ((ClassTuple)obj).tuple);
		}
	}
	
	private AbstractMap<ClassTuple, DispatchableMethod<DataType>> cache;
	
	public Method2(MethodComparator<DataType> methodComparator, AbstractMap<ClassTuple, DispatchableMethod<DataType>> cacheMap) {
		super(2, methodComparator);
		this.cache = cacheMap;
	}
	
	protected void resetCache() {
		cache.clear();
	}
	
	public ReturnType invoke(Object... args) throws EVLException {
		
		// define tuple
		ClassTuple classTuple = new ClassTuple(args[0].getClass(), args[1].getClass());
		
		// search tuple in cache
		DispatchableMethod<DataType> method = cache.get(classTuple);

		try {
			// invoke the method
			return invokeMethod(method, args);
			
		} catch (NullPointerException e) {
			// calculate the invoked method and put it in the cache
			if (method == null) {			
				method = processClassTuple(args);
				cache.put(classTuple, method);
				
			} else {
				throw e;
			}
			
			// invoke the method
			return invokeMethod(method, args);
		}
	}
		
}
