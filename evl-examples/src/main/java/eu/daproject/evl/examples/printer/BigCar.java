package eu.daproject.evl.examples.printer;

import eu.daproject.evl.Cases;
import eu.daproject.evl.examples.common.Car;

public class BigCar extends Car {

	public BigCar() {
		super("blue");
	}
	
	static {
		Print.method().add(new Cases() {
			String match(XML xml, BigCar car) {
				return "<bigCar color=\"" + car.getColor() + "\"/>";
			}
		});
	}
}
