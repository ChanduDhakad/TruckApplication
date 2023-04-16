package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Truck;

@Repository
public interface TruckDao extends JpaRepository<Truck,Integer>{


}
