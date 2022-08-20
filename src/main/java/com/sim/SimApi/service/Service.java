package com.sim.SimApi.service;

import com.sim.SimApi.entity.Record;
import com.sim.SimApi.exception.MobileNoException;
import com.sim.SimApi.exception.RecordNotFoundException;

import java.util.List;

public interface Service {
    Record addRecord(Record record) throws MobileNoException;

    List<Record> getAllRecord();

    Record updateRecord(Integer id, Record record) throws RecordNotFoundException, MobileNoException;

    String deleteRecord(Integer id) throws RecordNotFoundException;

    List<Record> expiryRecord();
}
