package com.example.mysql_partitioning.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@ToString
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "test_data_example")
public class TestEntity {
    @Id
    private Integer id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "joined")
    private Date date;


    public TestEntity(Integer id, String firstName, Date date) {
        this.id = id;
        this.firstName = firstName;
        this.date = date;

    }
}
