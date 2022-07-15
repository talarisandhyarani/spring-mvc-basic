package com.cgi.springmvc.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cgi.springmvc.beans.ActiveProject;

public interface ActiveProjectRepository extends JpaRepository<ActiveProject,Long>{

    @Query(value = "SELECT * FROM ActiveProjectRepository a", nativeQuery = true)
    List<ActiveProject> values();

    
    
}
