package com.jpmc.trade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpmc.trade.model.SSIData;

@Repository
public interface SSIDataRepository extends JpaRepository<SSIData, Integer> {

	public SSIData findBySsiCode(String ssiCode);
}
