package com.jspider.esop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jspider.esop.entity.Allocation;

@Repository
public interface AllocationGrantRepository extends JpaRepository<Allocation, Long> {
	
	

}
