package com.cgi.springmvc.services;

import java.util.List;

import com.cgi.springmvc.beans.ActiveProject;

public interface ActiveProjectService {
    public abstract void createActiveProjectService(ActiveProjectService activeProjectService);
    public abstract void updateActiveProjectService(String id, ActiveProjectService activeProjectService);
    public abstract void deleteActiveProjectService(String id);
    public abstract List<ActiveProject> getActiveProject();
    
}
