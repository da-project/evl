1.1.0
-----

* Java 9 Module.
* Automatic access in Multimethod class.
* NoMatchingMethodException and AmbiguousMethodException are now thrown by a cached method.
* Added MultiMethod.setData().
* Method MultiMethod.resetCache() renamed into MultiMethod.clearCache().
* Method nonVirtualParameterTypes() added.
* Method returnType() added.
* Methods getComparator(), getReturnType(), getNonVirtualParameterTypes() added.
* Method symmetricComparator() added.
* Added access() method in MultiMethod and extended addMethodFamily() to all inherited classes.
* Added check() method.
* Synchronized access to the members of MultiMethod.
* Added Method5, Method6, Method7 classes.
* Renamed MethodAddException into MethodNotAddedException.
* Added methods notOverridable() and setFinal() in MultiMethod.
* Added method compareWithPriority() in MethodComparator to help to define the real compare methods.

1.0.1
-----

* Support Java >= 11, abandoned evl-lookup with special implementation for old Java.
* Tests with JUnit 5.

1.0.0
-----

* First release to Maven central.