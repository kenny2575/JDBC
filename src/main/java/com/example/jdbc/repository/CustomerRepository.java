package com.example.jdbc.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class CustomerRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private String query;

    public CustomerRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        query = read("queryCustomer.sql");
    }

    public List<String> getProductName(String name){
        return namedParameterJdbcTemplate.queryForList(query, Map.of("name", name), String.class);
    }

    private static String read(String scriptFileName){
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))){
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}