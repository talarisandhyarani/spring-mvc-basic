package com.cgi.springmvc.repository;

import com.cgi.springmvc.beans.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long>{
    @Query(value = "SELECT * FROM Project p", nativeQuery = true)
    Optional<ArrayList<Project>> getAllProjects();
}
