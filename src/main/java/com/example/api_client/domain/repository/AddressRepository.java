package com.example.api_client.domain.repository;

import com.example.api_client.domain.entity.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository extends JpaRepository<Address, Long>{
    
}
