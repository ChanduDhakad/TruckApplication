package com.masai.service;

import java.util.List;

import com.masai.Exception.TruckException;
import com.masai.Exception.UserException;
import com.masai.model.Truck;

public interface vehicleService {
	
	
	public List<Truck> getAllTruckDetails(String email)throws TruckException,UserException;
	public  Truck getTruckByID(Integer truckId,String email)throws TruckException,UserException;
	public Truck updateTruckDetails(Truck truck,String email)throws TruckException,UserException;
	public Truck  removeExistTruck(Integer truckId,String email)throws TruckException,UserException;

}
