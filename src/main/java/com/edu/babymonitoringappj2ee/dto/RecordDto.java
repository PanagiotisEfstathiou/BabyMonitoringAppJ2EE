package com.edu.babymonitoringappj2ee.dto;

import com.edu.babymonitoringappj2ee.model.Record;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class RecordDto {

    private int id;
    private double duration;
    private Date date;
    private double quantity;
    private AccountDto account;

    public RecordDto(int id, double duration, Date date, double quantity, AccountDto account){
        this.id = id;
        this.duration = duration;
        this.date = date;
        this.quantity = quantity;
        this.account = account;
    }

    public Record createRecord(){
        Record record = new Record();
        record.setId(id);
        record.setDuration(duration);
        record.setDate(date);
        record.setQuantity(quantity);
        record.setAccount(account.createAccount());
        return record;
    }

    public RecordDto(Record record){
        id = record.getId();
        duration = record.getDuration();
        date = record.getDate();
        quantity = record.getQuantity();
        account = new AccountDto(record.getAccount());
    }
}
