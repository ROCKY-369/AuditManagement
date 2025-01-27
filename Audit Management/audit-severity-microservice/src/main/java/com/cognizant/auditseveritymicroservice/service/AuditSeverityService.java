package com.cognizant.auditseveritymicroservice.service;

import java.util.List;

import com.cognizant.auditseveritymicroservice.dto.AuditRequest;
import com.cognizant.auditseveritymicroservice.dto.AuditResponse;
import com.cognizant.auditseveritymicroservice.model.AuditHistory;
import com.cognizant.auditseveritymicroservice.model.AuditRequestModel;
import com.cognizant.auditseveritymicroservice.model.AuditResponseModel;

import org.springframework.stereotype.Service;

@Service
public interface AuditSeverityService {

    public List<AuditHistory> getHistory();

    public AuditRequestModel acceptRequest(AuditRequest request);

    public AuditResponseModel acceptResponse(AuditResponse response);
    
    
}
