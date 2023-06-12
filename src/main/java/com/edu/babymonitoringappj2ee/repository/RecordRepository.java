package com.edu.babymonitoringappj2ee.repository;

import com.edu.babymonitoringappj2ee.model.Record;

import java.util.Optional;

public interface RecordRepository {

    void save (Record record);

    Optional<Record> findById(int id);

    Optional<Record> update(int recordId, Record record);

    boolean delete(int recordId);

    Optional<Record> findByAccountId(int accountId);
}
