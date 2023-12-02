package com.assessment.controllers.views;

public class DeleteResponse{
    private Boolean status;

    public DeleteResponse(Boolean status) {
        this.status = status;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
