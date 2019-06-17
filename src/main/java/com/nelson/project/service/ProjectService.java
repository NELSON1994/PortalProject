package com.nelson.project.service;

import com.nelson.project.domain.Project;
import com.nelson.project.exceptipon.ProjectIdException;
import com.nelson.project.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectService {
@Autowired
    private ProjectRepository projectRepository;

    /**
     * creating project service
     * @param project
     * @return
     */
    public Project saveOrUpdateProject(Project project){
    try {
        project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
        return projectRepository.save(project);
    }
    catch (Exception e){
        throw new ProjectIdException("Project id" + project.getProjectIdentifier().toUpperCase() + ", already exist");
    }

}
/**
 * find all projects
 */
public Iterable<Project> findAllProjects(){
return projectRepository.findAll();
}

    /**
     * finding project by ID
     * @param projectId
     * @return
     */
    public Optional<Project> findById(Long projectId) {
        return projectRepository.findById(projectId);
    }

    /**
     * FINDING PROJECT BY PROJECTIDENTIFIER
     * @param projectIdentifier
     * @return
     */
    public Project findByProjectIdentifier(String projectIdentifier) {
        //checking if the project with the given identifier exist or not
        Project p = projectRepository.findByProjectIdentifier(projectIdentifier);
    if(p == null){
        throw new ProjectIdException("Project identifier of " +projectIdentifier + "not found");
    }
        return p;
    }
    /**
     * Updating project details
     */
public Project updateProject(Project project, String projectIdentifier){
    Project p = projectRepository.findByProjectIdentifier(projectIdentifier);
    if(p == null){
        throw new ProjectIdException("Project identifier of " +projectIdentifier + "not found");
    }
   p.setDescription(project.getDescription());
    p.setProjectName(project.getProjectName());
    return projectRepository.save(p);
}

    /**
     * deleting project using project identifier
      */

    public void deleteProject(String projectId){
        Project p = projectRepository.findByProjectIdentifier(projectId);
        if(p == null){
            throw new ProjectIdException("Project identifier of " +projectId + "not found");
        }
      projectRepository.delete(p);
    }
}
