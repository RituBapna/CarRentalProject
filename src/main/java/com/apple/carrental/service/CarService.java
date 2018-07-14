package com.apple.carrental.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.apple.carrental.bean.Car;

public class CarService {
	
	/**
	 * Returns make, color and notes of cars whose make is Tesla and color is blue
	 */
	public static List<Car> printBlueTeslaAndNotes(Map<String,Car> carMap) {
		if(carMap== null) {
			return null;
		}
		ArrayList<Car> response = new ArrayList<Car>();
		for (Map.Entry<String, Car> entry : carMap.entrySet()) {
		    Car value = entry.getValue();
		    if(value.getMetadata().getColor().equalsIgnoreCase("blue") &&
		    		value.getMake().equalsIgnoreCase("Tesla")) {
		    	response.add(value);
		    
		    }
		}
		return response;
		
	}
	
	/**
	 * Returns the lowest perday rental prize
	 */
	public static List<Car> getLowestPerDayRentalCars(Map<String,Car> carMap) {
		if(carMap== null) {
			return null;
		}
		List<Car> list= new ArrayList<>();
		Float lowPrize= Float.MAX_VALUE;
		for (Map.Entry<String, Car> entry : carMap.entrySet()) {
		    Car value = entry.getValue();
		    if(value.getPerdayrent().getPrice()< lowPrize) {
			    	lowPrize= value.getPerdayrent().getPrice();
			    	list= new ArrayList<>();
			    	list.add(value);
		    }
		}
		return list;
		
	}
	
	/**
	 * Returns the lowest perday rental prize after discount
	 */
	
	public static List<Car> getLowestPerDayRentalCarsAfterDiscount(Map<String,Car> carMap) {
		if(carMap== null) {
			return null;
		}
		List<Car> list= new ArrayList<>();
		Float minPrizeAfterDiscount= Float.MAX_VALUE;
		Float prizeAfterDiscount;
		for (Map.Entry<String, Car> entry : carMap.entrySet()) {
		    Car value = entry.getValue();
		    prizeAfterDiscount=value.getPerdayrent().getPrice()-value.getPerdayrent().getDiscount();
		    if(prizeAfterDiscount< minPrizeAfterDiscount) {
		    	minPrizeAfterDiscount= prizeAfterDiscount;
		    	list= new ArrayList<>();
		    	list.add(value);
		    }
		}
		return list;
	}
	
	/**
	 * Returns highest revenue generating car make
	 */
	public static List<Car> printHighestRevenueGeneratingCar(Map<String, Car> carMap) {
		if(carMap== null) {
			return null;
		}
		
		ArrayList<Car> response = new ArrayList<Car>();
		Float maxRevenue= Float.MIN_VALUE;
		Float revenue;
		
		for (Map.Entry<String, Car> entry : carMap.entrySet()) {
		    Car value = entry.getValue();
		    revenue=value.getMetrics().getRentalcount().getYeartodate() *(
		    		value.getPerdayrent().getPrice()- value.getPerdayrent().getDiscount())-
		    		value.getMetrics().getYoymaintenancecost()+value.getMetrics().getDepreciation();
		    if(maxRevenue< revenue) {
			    	maxRevenue=revenue;
			    	response= new ArrayList<>();
			    	response.add(value);
		    }
		    
		}
		return response;
	}
	
	/**
	 * Prints car details
	 */
	public static void printCars(List<Car> carList) {
		for (Car car : carList) {
			System.out.println(car);
		}
	}
	
	

}
