package com.example.TheaterManager.repository;

import com.example.TheaterManager.models.entities.Performance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerformanceRepository extends JpaRepository<Performance, Long> {

    @Query(nativeQuery = true, value =
            "select * from performance\n" +
                    "order by start_time\n" +
                    "limit 6")
    List<Performance> findAllByStartTime();
}
