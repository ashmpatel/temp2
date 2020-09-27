package com.example.testingwebapp.service;

import com.example.testingwebapp.GridId;
import com.example.testingwebapp.model.SubmtBatchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DSAACService {

    // point this to the right DSAAC web server address
    public static String DSAAC_WEB_SERVER_ADDRESS= "http://localhost:8080";

    @Autowired
    RestTemplate callWebApp;

    public SubmtBatchResponse getDataForGrids(GridId gridIds) {
        SubmtBatchResponse responseForBatchSumbission = callWebApp.postForObject(
                DSAAC_WEB_SERVER_ADDRESS + "/v1/",gridIds, SubmtBatchResponse.class);
        return responseForBatchSumbission;
    }

    public String health() {
        return "OK";
    }
}
