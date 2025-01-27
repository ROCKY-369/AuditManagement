package com.cognizant.auditseveritymicroservice.service;


import java.util.ArrayList;
import java.util.List;

import com.cognizant.auditseveritymicroservice.dto.AuditRequest;
import com.cognizant.auditseveritymicroservice.dto.AuditResponse;
import com.cognizant.auditseveritymicroservice.model.AuditDetailsModel;
import com.cognizant.auditseveritymicroservice.model.AuditHistory;
import com.cognizant.auditseveritymicroservice.model.AuditRequestModel;
import com.cognizant.auditseveritymicroservice.model.AuditResponseModel;
import com.cognizant.auditseveritymicroservice.repository.AuditRequestRepo;
import com.cognizant.auditseveritymicroservice.repository.AuditResponseRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditSeverityServiceImpl implements AuditSeverityService{

    @Autowired
    private AuditResponseRepo auditResponseRepo;

    @Autowired
    private AuditRequestRepo auditRequestRepo;
    /**
     * This method takes the request details from user
     * @param request
     * @return auditRequestModel
     */
    @Override
    public AuditRequestModel acceptRequest(AuditRequest request){
        String auditType=request.getAuditDetails().getAuditType();
        AuditDetailsModel auditDetails= new AuditDetailsModel(auditType);
        AuditRequestModel auditRequestModel= new AuditRequestModel();
        auditRequestModel.setProjectName(request.getProjectName());
        auditRequestModel.setProjectManagerName(request.getProjectManagerName());
        auditRequestModel.setApplicatonOwnerName(request.getApplicationOwnerName());
        auditRequestModel.setAuditDetails(auditDetails);
        return auditRequestRepo.save(auditRequestModel);

    }
    /**
     * This method will gives the response to user
     * @param response
     * @return auditResonseModel
     */
    public AuditResponseModel acceptResponse(AuditResponse response){
        AuditResponseModel auditResponseModel=new AuditResponseModel(response.getProjectExecutionStatus(), response.getRemedialActionDuration());
        return auditResponseRepo.save(auditResponseModel);
        
    }
    /**
     * This method stores all the rquests and responses.
     * @param 
     * @return List<audits>
     */
    public List<AuditHistory> getHistory(){
        List<AuditResponseModel> auditResponseModelList=auditResponseRepo.findAll();
        List<AuditRequestModel> auditRequestModelList=auditRequestRepo.findAll();
        List<AuditHistory> auditHistoryList=new ArrayList<>();
        for(int i=0;i<auditRequestModelList.size();i++){
            AuditRequestModel auditRequest=auditRequestModelList.get(i);
            AuditResponseModel auditResponse=auditResponseModelList.get(i);
            boolean status;
            if(auditResponse.getProjectExecutionStatus().equalsIgnoreCase("Green")){
                status=true;                
            }
            else{
                status=false;
            }
            AuditHistory auditHistory=new AuditHistory(auditResponse.getAuditId(),auditRequest.getProjectName(),auditRequest.getProjectManagerName(),auditRequest.getApplicatonOwnerName(),
            auditRequest.getAuditDetails().getAuditType(),auditRequest.getAuditDetails().getAuditDate().toString(),
            status,auditResponse.getRemedialActionDuration());
            auditHistoryList.add(auditHistory);
        }
        return auditHistoryList;
    }

}
