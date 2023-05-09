package com.example.mysql_partitioning.repositroy;


import com.example.mysql_partitioning.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface TestRepo extends CrudRepository<TestEntity, Integer> {
//    void findAll(String firstName);

}
