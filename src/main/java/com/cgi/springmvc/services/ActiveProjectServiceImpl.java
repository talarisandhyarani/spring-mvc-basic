package com.cgi.springmvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cgi.springmvc.beans.ActiveProject;
import com.cgi.springmvc.repository.ActiveProjectRepository;

public class ActiveProjectServiceImpl implements ActiveProjectService {

    @Autowired
    ActiveProjectRepository activeProjectRepository;

    @Override
    public void createActiveProjectService(ActiveProjectService activeProjectService) {
        
    }
    @Override
    public void updateActiveProjectService(String id, ActiveProjectService activeProjectService) {
        
    }
    @Override
    public void deleteActiveProjectService(String id) {
        
    }
    @Override
    public List<ActiveProject> getActiveProject() {
        return activeProjectRepository.values();
    }
}
