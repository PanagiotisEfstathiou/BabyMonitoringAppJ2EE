package com.edu.babymonitoringappj2ee.repository.impl;

import com.edu.babymonitoringappj2ee.model.Record;
import com.edu.babymonitoringappj2ee.repository.RecordRepository;

import java.sql.*;
import java.util.Optional;

public class RecordRepositoryImpl implements RecordRepository {

    private    static final String DB_URL = "jdbc:sqlserver://localhost;databaseName=BabyMonJ2EE;encrypt=true;trustServerCertificate=true;";
    private  static final String USER = "admin";
    private  static final String PASS = "1234";
    private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    @Override
    public void save(Record record) {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String sqlCommand = "insert into Record (duration, date, quantity) values(?,?,?);";

        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement(sqlCommand,
                    Statement.RETURN_GENERATED_KEYS )){
            stmt.setDouble(1,record.getDuration());
            stmt.setDate(2, (Date) record.getDate());
            stmt.setDouble(3,record.getQuantity());
            stmt.execute();
            ResultSet results = stmt.getGeneratedKeys();
            results.next(); // Assume just one auto-generated key; otherwise, use a while loop here
            int index = results.getInt(1);
            record.setId(index);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Record> findById(int id) {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String sqlCommand = "select * from  Record where id =?;";
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement(sqlCommand,
                    Statement.RETURN_GENERATED_KEYS )){
            stmt.setInt(1,id);
            ResultSet results = stmt.executeQuery();
            if(results.next()){
                Record record = new Record();
                record.setId(results.getInt("id"));
                record.setDuration(results.getDouble("duration"));
                record.setDate(results.getDate("date"));
                record.setQuantity(results.getDouble("quantity"));
                return Optional.of(record);
            }
            else {
                return Optional.empty();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Record> update(int recordId, Record record) {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String sqlCommand = "update Record set duration = ?, date = ?, quantity = ? where id = ?;";
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement(sqlCommand,
                    Statement.RETURN_GENERATED_KEYS )){
            stmt.setDouble(1,record.getDuration());
            stmt.setDate(2, (Date) record.getDate());
            stmt.setDouble(3,record.getQuantity());
            stmt.setInt(4,recordId);
            stmt.execute();
            ResultSet results = stmt.getGeneratedKeys();
            results.next(); // Assume just one auto-generated key; otherwise, use a while loop here
            int index = results.getInt(1);
            record.setId(index);
            return Optional.of(record);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(int recordId) {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String sqlCommand = "delete from Record where id = ?;";
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement(sqlCommand,
                    Statement.RETURN_GENERATED_KEYS )){
            stmt.setInt(1,recordId);
            stmt.execute();
            ResultSet results = stmt.getGeneratedKeys();
            results.next(); // Assume just one auto-generated key; otherwise, use a while loop here
            int index = results.getInt(1);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
