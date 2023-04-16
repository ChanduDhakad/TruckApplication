package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.TruckException;
import com.masai.Exception.UserException;
import com.masai.model.Truck;
import com.masai.model.User;
import com.masai.repository.TruckDao;
import com.masai.repository.UserDao;
@Service
public class vehicleServiceImpl implements vehicleService {

	
	@Autowired
	private UserDao uDao;
	
	@Autowired
	private TruckDao tDao;
	
	
	
	
	@Override
	public List<Truck> getAllTruckDetails(String email) throws TruckException,UserException {
		List<Truck> trucksList=new ArrayList<>();
		 
		Optional<User> isUserExist=uDao.findByEmail(email);
		
		if(isUserExist.isPresent()) {
			User user=isUserExist.get();
			
		  if(user.getRole().equalsIgnoreCase("manager")) {
			  trucksList=tDao.findAll();
			  
			  if(trucksList.size()>0) {
				  throw new TruckException("Empty Truck in the  Database");
			  }
		  }
		  else {
				throw new UserException("User Is Not Manager  so that he can not access the List Of All Truck ");
		  }
		}
		else {
			throw new UserException("User Is Not Available with  Given Email ID");
		}
		  
		 
		return trucksList;
	}

	@Override
	public Truck getTruckByID(Integer truckId, String email) throws TruckException, UserException {
		Truck truck=null;
		
		Optional<Truck> isTruckExist=tDao.findById(truckId);
		
		if(isTruckExist.isPresent()) {
		
		Optional<User>  optUser=uDao.findByEmail(email);
		
			if(optUser.isPresent()) {
				
				User user=optUser.get();
				
				if(user.getRole().equalsIgnoreCase("Manager")) {
					
					truck=isTruckExist.get();
							
				}
				else if(user.getRole().equalsIgnoreCase("Driver")) {
					
					if(user.getTruck().getTrackId()==truckId) {
						truck=isTruckExist.get();
						
					}
					
				}
				else if(user.getRole().equalsIgnoreCase("Guest")) {
					
					throw new UserException("Truck  Id can be check Is Only For Manager Or Driver Not Guest");
				}			
			}
			else {
				
				throw new UserException("User Is Not Available with Given Email");
				
			}
			
			
			
		}
		else {
			
			throw new TruckException("Truck Is Not Availble with Given Id");
		}
		
 		
		
		return truck;
	}

	@Override
	public Truck  updateTruckDetails(Truck truck,String email) throws TruckException, UserException {
	Truck truck2=null;
		
		Optional<User> isUserExist=uDao.findByEmail(email);
		
		if(isUserExist.isPresent()) {
			User user=isUserExist.get();
			
			Optional<Truck> optTruck=tDao.findById(truck.getTrackId());
 			
			if(optTruck.isPresent()) {
			
		 
					if(user.getRole().equalsIgnoreCase("Manager")) {
						
						truck2=tDao.save(truck);
								
					}
					
					else if(user.getRole().equalsIgnoreCase("Driver")) {
						
						if(user.getTruck().getTrackId()==truck.getTrackId()) {
							truck2=tDao.save(truck);
							
						}
						
					}
					if(user.getRole().equalsIgnoreCase("Guest")) {
					
						throw new UserException("Truck Update Is Only For Manager Or Driver Not Guest");
						
					}
			}
			else {
				throw new TruckException("Truck Is Not Available By Id");
			}
		}
		else {
			throw new UserException("User Is Not Availble By Given Email");
		}
		
		
		
		
	return truck2;	
	}

	@Override
	public Truck removeExistTruck(Integer truckId, String email) throws TruckException, UserException {
	Truck truck=null;
		
		Optional<Truck> isTruckExist=tDao.findById(truckId);
		
		if(isTruckExist.isPresent()) {
		
		Optional<User>  optUser=uDao.findByEmail(email);
		
			if(optUser.isPresent()) {
				
				User user=optUser.get();
				
				if(user.getRole().equalsIgnoreCase("Manager")) {
					
					truck=isTruckExist.get();
					tDao.delete(truck);
							
				}
				else if(user.getRole().equalsIgnoreCase("Driver")) {
					
					if(user.getTruck().getTrackId()==truckId) {
						truck=isTruckExist.get();
						tDao.delete(truck);
						
					}
					
				}
				else if(user.getRole().equalsIgnoreCase("Guest")) {
					
					throw new UserException("Truck Delete By Id Is Only For Manager Or Driver Not Guest");
				}			
			}
			else {
				
				throw new UserException("User Is Not Available By Given Email");
				
			}
			
		}
		else {
			
			throw new TruckException("Truck Is Not Availble By Given Id");
		}
		
 		
		
		return truck;
	}


}
