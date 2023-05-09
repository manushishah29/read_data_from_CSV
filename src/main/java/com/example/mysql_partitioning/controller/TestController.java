package com.example.mysql_partitioning.controller;


import com.example.mysql_partitioning.entity.TestEntity;
import com.example.mysql_partitioning.repositroy.TestRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestRepo testRepo;


    //    @GetMapping("/")
//    public List<TestEntity> getPartitionData(){
//        return testRepo.getAllByPartition();
//    }
//
//    @GetMapping("/date")
//    public List<TestEntity> betweenDate(@RequestParam String startDate, @RequestParam String endDate) throws ParseException {
//        return testRepo.findByDateBetween(new SimpleDateFormat("yyyy-MM-dd").parse(startDate), new SimpleDateFormat("yyyy-MM-dd").parse(endDate));
//    }
    @GetMapping("/insert")
    public String insertDataInCSV() {
        testRepo.saveAll(parseCsvFile());
        return "inserting";
    }

    private static List<TestEntity> parseCsvFile() {
        List<TestEntity> dataList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("/home/dev1053/kafka_project/mysql_partitioning/src/main/resources/output.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                TestEntity testEntity = new TestEntity(Integer.parseInt(values[0]), values[1], new SimpleDateFormat("yyyy-MM-dd").parse(values[2]));
                dataList.add(testEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataList;
    }
}
