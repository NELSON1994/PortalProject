package com.nelson.project.web;

import com.nelson.project.domain.Project;
import com.nelson.project.service.MapValidationErrorService;
import com.nelson.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


/**
 * @author Nelson
 */
@RestController
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;
    /**
     * creating project
     * @param project
     * @param bindingResult
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project , BindingResult bindingResult){
    ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationErrorService(bindingResult);
    if(errorMap != null){
        return errorMap;
    }
        Project project1 = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(project1, HttpStatus.CREATED);
    }
/**
 * fetching all projects
 */
@GetMapping("/allprojects")
public Iterable<Project> getAllProjects(){
    return projectService.findAllProjects();
}
 /**
     * fetching by project identifier
     * @param projectIdentifier
     * @return
     */
    @GetMapping("/fetch/{projectIdentifier}")
    public ResponseEntity<?> getProjectByIdentifier(@PathVariable String projectIdentifier){
        Project project1 = projectService.findByProjectIdentifier(projectIdentifier.toUpperCase());
        return new ResponseEntity<Project>(project1, HttpStatus.OK);
    }
    /**
     * UPDATING PROJECT DETAILS
     */

    @PutMapping("/updateproject/{projectIdentifier}")
    public ResponseEntity<Object> updateProject(@PathVariable String projectIdentifier, @RequestBody Project p) {
        Project pro = projectService.findByProjectIdentifier(projectIdentifier);
        if(!(pro == null)){
           projectService.updateProject(pro,projectIdentifier);
            return new ResponseEntity<>("Project of Identifier : " +projectIdentifier+ "was suceesfully updated" , HttpStatus.OK);
        }
       return  null;
    }
    /**
     * deleting project
     */
    @DeleteMapping("/deleteproject/{projectId}")
    public ResponseEntity<?> deleteProject(@PathVariable String projectId){
        projectService.deleteProject(projectId.toUpperCase());
        return new ResponseEntity<String >("Project of Identifier : " +projectId+ "was deleted" , HttpStatus.OK);
    }
}
