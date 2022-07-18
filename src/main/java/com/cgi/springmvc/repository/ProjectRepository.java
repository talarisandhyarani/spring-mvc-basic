package com.cgi.springmvc.repository;

import com.cgi.springmvc.beans.Project;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long>{
    @Query(value = "SELECT * FROM projects p", nativeQuery = true)
    List<Project> values();
}
