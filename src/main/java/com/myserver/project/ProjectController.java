package com.myserver.project;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/portfolio")
@AllArgsConstructor
public class ProjectController {
    private ProjectService projectService;

    @PostMapping(path = "add")
    public Long addProject(@RequestBody ProjectRequest projectRequest){
        return projectService.addProject(projectRequest);
    }
}
