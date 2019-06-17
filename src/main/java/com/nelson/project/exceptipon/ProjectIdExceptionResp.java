package com.nelson.project.exceptipon;

public class ProjectIdExceptionResp {
    private String projectIdentifier;

    public ProjectIdExceptionResp(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public ProjectIdExceptionResp setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
        return this;
    }
}
