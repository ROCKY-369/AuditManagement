package com.cognizant.benchmark.service;

import static org.junit.Assert.assertNotNull;


import java.util.List;
import com.cognizant.benchmark.model.AuditBenchmark;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class AuditBenchmarkServiceTest {

  
    private AuditBenchmarkService benchmarkService;
    private List<AuditBenchmark> auditBenchmarkList ;
    
    @BeforeEach
    public void init() {
    	benchmarkService=new AuditBenchmarkService();
    	auditBenchmarkList = List.of(
    	            new AuditBenchmark("Internal", 3),
    	            new AuditBenchmark("SOX", 1)
    	            );
    }
    /**
     * Test method to check banch mark list.
     */
    @Test
    public void testFetchBenchmarkList(){
        assertNotNull( benchmarkService.fetchBenchmarkList());
    }
}
