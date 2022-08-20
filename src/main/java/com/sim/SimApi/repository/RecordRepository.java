package com.sim.SimApi.repository;

import com.sim.SimApi.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, Integer> {

    @Query(value = "select * from record  where expiry_date <= CURRENT_DATE + 30", nativeQuery = true)
    List<Record> getAllByExpiryDate();
}
