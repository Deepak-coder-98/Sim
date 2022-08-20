package com.sim.SimApi.controller;

import com.sim.SimApi.entity.Record;
import com.sim.SimApi.exception.MobileNoException;
import com.sim.SimApi.exception.RecordNotFoundException;
import com.sim.SimApi.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private Service service;

    @GetMapping("/")
    public ResponseEntity<String> homePage() {

        return new ResponseEntity<>("Weclome to Home Page", HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Record> addRecord(@RequestBody Record record) throws MobileNoException {
        Record recordVo = service.addRecord(record);
        return new ResponseEntity<>(recordVo, HttpStatus.OK);
    }

    @GetMapping("/listall")
    public ResponseEntity<List<Record>> getAllRecord() {
        List<Record> recordList = service.getAllRecord();
        return new ResponseEntity<>(recordList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Record> updateRecord(@PathVariable Integer id, @RequestBody Record record) throws RecordNotFoundException, MobileNoException {
        Record recordVo = service.updateRecord(id, record);
        return new ResponseEntity<>(recordVo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecord(@PathVariable Integer id) throws RecordNotFoundException {
        String message = service.deleteRecord(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/to-renew")
    public ResponseEntity<List<Record>> expiryRecord() {
        List<Record> recordList = service.expiryRecord();
        return new ResponseEntity<>(recordList, HttpStatus.OK);
    }

}
