package com.example.testingwebapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubmtBatchResponse {

    private long batchId;

    public SubmtBatchResponse() {
    }

    public long getBatchId() {
        return batchId;
    }

    public void setBatchId(long batchId) {
        this.batchId = batchId;
    }

    @Override
    public String toString() {
        return "SubmtBatchResponse{" +
                "batchId=" + batchId +
                '}';
    }
}