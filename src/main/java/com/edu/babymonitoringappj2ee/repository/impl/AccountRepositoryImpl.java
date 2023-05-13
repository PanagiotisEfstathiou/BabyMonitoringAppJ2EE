package com.edu.babymonitoringappj2ee.repository.impl;

import com.edu.babymonitoringappj2ee.model.Account;
import com.edu.babymonitoringappj2ee.repository.AccountRepository;

import java.sql.*;
import java.util.Optional;

public class AccountRepositoryImpl implements AccountRepository {

    private    static final String DB_URL = "jdbc:sqlserver://localhost;databaseName=BabyMonJ2EE;encrypt=true;trustServerCertificate=true;";
    private  static final String USER = "admin";
    private  static final String PASS = "1234";
    private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    @Override
    public void save(Account account) {
        try{
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String sqlCommand = "insert into Account (name) values(?);";

        //Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement(sqlCommand,
                    Statement.RETURN_GENERATED_KEYS )){
            stmt.setString(1,account.getName());
            stmt.execute();
            ResultSet results = stmt.getGeneratedKeys();
            results.next(); // Assume just one auto-generated key; otherwise, use a while loop here
            int index = results.getInt(1);
            account.setId(index);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Account> findById(int id) {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String sqlCommand = "select * from  Account where id =?;";

        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement(sqlCommand,
                    Statement.RETURN_GENERATED_KEYS )){
            stmt.setInt(1,id);
            ResultSet results = stmt.executeQuery();
            if(results.next()){
                Account account = new Account();
                account.setId(results.getInt("id"));
                account.setName(results.getString("name"));
                return Optional.of(account);
            }
            return Optional.empty();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Account> update(int accountId, Account account) {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String sqlCommand = "update Account set name = ? where id = ?;";
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement(sqlCommand,
                    Statement.RETURN_GENERATED_KEYS )){
            stmt.setString(1,account.getName());
            stmt.setInt(2,accountId);
            stmt.execute();
            ResultSet results = stmt.getGeneratedKeys();
            results.next(); // Assume just one auto-generated key; otherwise, use a while loop here
            int index = results.getInt(1);
            account.setId(index);
            return Optional.of(account);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(int accountId) {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String sqlCommand = "delete from Account where id = ?;";
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement(sqlCommand,
                    Statement.RETURN_GENERATED_KEYS )){
            stmt.setInt(1,accountId);
            stmt.execute();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
