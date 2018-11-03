package org.bitbucket.evl.exception;

import org.bitbucket.evl.util.MethodClassTuple;

public class AmbiguousMethodException extends InvocationException {

	private static final long serialVersionUID = 5L;
	
	public AmbiguousMethodException(MethodClassTuple tuple, String possibleMethods) {
		super("Ambiguity for tuple of types " + tuple + ", possible methods are\n" + possibleMethods);
	}
}
