package com.fp.solid.singleresponsability.solution;

public class Vehicle {

	public int getWheelCount() {
		return 4;
	}
	
	public int getMaxSpeed() {
		return 200;
	}

	@Override
	public String toString() {
		return "Vehicle [getWheelCount()=" + getWheelCount() + ", getMaxSpeed()=" + getMaxSpeed() + "]";
	}
	

}