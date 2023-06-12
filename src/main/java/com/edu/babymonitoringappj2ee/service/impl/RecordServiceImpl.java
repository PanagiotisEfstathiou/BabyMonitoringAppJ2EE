package com.edu.babymonitoringappj2ee.service.impl;

import com.edu.babymonitoringappj2ee.dto.RecordDto;
import com.edu.babymonitoringappj2ee.model.Record;
import com.edu.babymonitoringappj2ee.repository.RecordRepository;
import com.edu.babymonitoringappj2ee.service.RecordService;

import javax.inject.Inject;
import java.util.Optional;

public class RecordServiceImpl implements RecordService {
    @Inject
    private RecordRepository repository;

    @Override
    public RecordDto saveRecord(RecordDto record) {
        Record record1 = record.createRecord();
        repository.save(record1);
        return new RecordDto(record1);
    }

    @Override
    public RecordDto readRecord(int recordId) {
        Optional<Record> record = repository.findById(recordId);
        if (record.isPresent())
            return new RecordDto(record.get());
        else
            return null;
    }

    @Override
    public RecordDto readRecordByAccountId(int accountId) {
        Optional<Record> record = repository.findByAccountId(accountId);
        if (record.isPresent())
            return new RecordDto(record.get());
        else
            return null;
    }

    @Override
    public RecordDto updateRecord(int recordId, RecordDto record) {
        Record record1 = record.createRecord();
        return new RecordDto (repository.update(recordId, record1).get());
    }

    @Override
    public boolean deleteRecord(int recordId) {
        return repository.delete(recordId);
    }
}
