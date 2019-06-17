package com.nelson.project.repositories;

import com.nelson.project.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends CrudRepository<Project , Long> {

    Project findByProjectIdentifier(String projectItifier);

     Optional<Project> findById(Long Id);
     @Override
    Iterable<Project> findAll();

}
