package com.edu.babymonitoringappj2ee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record {
    private int id;
    private double duration;
    private Date date;
    private double quantity;
    private Account account;
}
