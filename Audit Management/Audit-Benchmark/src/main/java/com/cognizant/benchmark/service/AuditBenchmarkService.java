package com.cognizant.benchmark.service;

import java.util.*;

import com.cognizant.benchmark.model.AuditBenchmark;

import org.springframework.stereotype.Service;

@Service
public class AuditBenchmarkService {
    /**
     * This service class returns the bench mark value based on audit type.
     * @param 
     * @return benchmark
     */
    public List<AuditBenchmark> fetchBenchmarkList(){
        List<AuditBenchmark> auditBenchmarkList = new ArrayList<AuditBenchmark>();
        auditBenchmarkList.add(new AuditBenchmark("Internal", 3));
		auditBenchmarkList.add(new AuditBenchmark("SOX", 1));
        return auditBenchmarkList;
    }
}
