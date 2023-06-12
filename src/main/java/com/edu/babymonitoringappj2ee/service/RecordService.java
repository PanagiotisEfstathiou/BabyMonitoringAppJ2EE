package com.edu.babymonitoringappj2ee.service;

import com.edu.babymonitoringappj2ee.dto.RecordDto;

public interface RecordService {

    RecordDto saveRecord(RecordDto record);

    RecordDto readRecord(int recordId);

    RecordDto readRecordByAccountId(int accountId);

    RecordDto updateRecord(int recordId, RecordDto record);

    boolean deleteRecord(int recordId);
}
