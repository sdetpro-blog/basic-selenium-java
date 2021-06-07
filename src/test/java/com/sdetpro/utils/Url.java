package com.sdetpro.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Url {

    private static final String JSON_FILE = System.getProperty("user.dir").concat("/src/test/resources/testing-urls.json");

    public static String currentTestUrl(String testPage) {
        ObjectMapper objectMapper = new ObjectMapper();
        String finalTestingUrl;

        try {
            FileInputStream fileInputStream = new FileInputStream(JSON_FILE);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            Map<String, HashMap> testingUrlData = objectMapper.readValue(bufferedReader, HashMap.class);
            String sitePath = testingUrlData.get(testPage).get("url").toString();
            finalTestingUrl = System.getProperty("testingUrl").concat(sitePath);

            // Close after interacting with the file
            bufferedReader.close();
            inputStreamReader.close();
            bufferedReader.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("ERR | issue when reading the testing url data json file!");
        }

        return finalTestingUrl;
    }

    public static void main(String[] args) {
        System.out.println(Url.currentTestUrl("LOGIN_PAGE"));
    }
}
