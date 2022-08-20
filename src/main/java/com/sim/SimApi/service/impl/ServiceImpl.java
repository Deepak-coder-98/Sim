package com.sim.SimApi.service.impl;

import com.sim.SimApi.entity.Record;
import com.sim.SimApi.exception.MobileNoException;
import com.sim.SimApi.exception.RecordNotFoundException;
import com.sim.SimApi.repository.RecordRepository;
import com.sim.SimApi.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    @Value("${Record_deleted}")
    String recordDeleted;
    @Autowired
    private RecordRepository recordRepository;

    @Override
    public Record addRecord(Record record) throws MobileNoException {

        if (record == null || record.getMobileNo().toString().length() != 10) {
            throw new MobileNoException("NOT A VALID MOBILE NUMBER...");
        }

        recordRepository.save(record);
        return record;

    }

    @Override
    public List<Record> getAllRecord() {

        List<Record> recordList = recordRepository.findAll();
        return recordList;
    }

    @Override
    public Record updateRecord(Integer id, Record newRecord) throws RecordNotFoundException, MobileNoException {

        Optional<Record> oldRecord = recordRepository.findById(id);

        if (!oldRecord.isPresent()) {
            throw new RecordNotFoundException("RECORD NOT FOUND");
        }

        if (Objects.nonNull(newRecord) && Objects.nonNull(newRecord.getMobileNo()) && newRecord.getMobileNo().toString().length() != 10) {
            throw new MobileNoException("NOT A VALID MOBILE NUMBER...");
        }

        recordRepository.delete(oldRecord.get());
        recordRepository.save(newRecord);

        return newRecord;

    }

    @Override
    public String deleteRecord(Integer id) throws RecordNotFoundException {

        Optional<Record> recordOptional = recordRepository.findById(id);
        if (!recordOptional.isPresent()) {
            throw new RecordNotFoundException("RECORD NOT FOUND");
        }

        recordRepository.delete(recordOptional.get());

        return recordDeleted + id;
    }

    @Override
    public List<Record> expiryRecord() {

        List<Record> recordList = recordRepository.getAllByExpiryDate();
        return recordList;
    }
}
