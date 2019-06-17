package com.nelson.project.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
@NotBlank(message = "project name is required")
    private  String projectName;
    @NotBlank(message = "projectidentifier name is required")
    @Size(min = 4, max = 5, message = "4or 5 characters required")
    @Column(updatable = false, unique = true)
    private  String projectIdentifier;
    @NotBlank(message = "project description is required")
    private  String description;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date start_date;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date end_date;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date created_At;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date updated_At;

    public Project() {
    }

    public Project(String projectName, String projectIdentifier, String description, Date start_date, Date end_date, Date created_At, Date updated_At) {
        this.projectName = projectName;
        this.projectIdentifier = projectIdentifier;
        this.description = description;
        this.start_date = start_date;
        this.end_date = end_date;
        this.created_At = created_At;
        this.updated_At = updated_At;
    }

    public Long getId() {
        return id;
    }

    public Project setId(Long id) {
        this.id = id;
        return this;
    }

    public String getProjectName() {
        return projectName;
    }

    public Project setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public Project setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Project setDescription(String description) {
        this.description = description;
        return this;
    }

    public Date getStart_date() {
        return start_date;
    }

    public Project setStart_date(Date start_date) {
        this.start_date = start_date;
        return this;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public Project setEnd_date(Date end_date) {
        this.end_date = end_date;
        return this;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public Project setCreated_At(Date created_At) {
        this.created_At = created_At;
        return this;
    }

    public Date getUpdated_At() {
        return updated_At;
    }

    public Project setUpdated_At(Date updated_At) {
        this.updated_At = updated_At;
        return this;
    }

    @PrePersist
    protected void onCreate(){
        this.created_At = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updated_At = new Date();
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", projectIdentifier='" + projectIdentifier + '\'' +
                ", description='" + description + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", created_At=" + created_At +
                ", updated_At=" + updated_At +
                '}';
    }
}
