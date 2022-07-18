package com.cgi.springmvc.repository;

import com.cgi.springmvc.beans.Employee;
import com.cgi.springmvc.beans.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long>{
    @Query(value = "SELECT * FROM Project p", nativeQuery = true)
    Optional<ArrayList<Project>> getAllProjects();

    @Query(value = "SELECT * FROM Project p WHERE p.project_Id LIKE :keyword OR p.project_Name LIKE :keyword OR" +
            " p.project_description LIKE :keyword", nativeQuery = true)
    Optional<List<Project>> getProjectByKeyword(@Param("keyword")String keyword);
}
