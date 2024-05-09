package com.taishinlife.tecm.controller.api;

import com.taishinlife.tecm.model.entity.ActGeProperty;
import com.taishinlife.tecm.service.ActGePropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/activti")
public class ActivtiFlowController {

    private final ActGePropertyService service;

    @Autowired
    public ActivtiFlowController(ActGePropertyService service) {
        this.service = service;
    }

    @PostMapping
    public ActGeProperty createActGeProperty(@RequestBody ActGeProperty newActGeProperty) {
        return service.saveActGeProperty(newActGeProperty);
    }

    // Add more methods as needed for your application
}