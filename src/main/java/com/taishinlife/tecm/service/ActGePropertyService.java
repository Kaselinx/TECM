package com.taishinlife.tecm.service;

import java.util.Optional;

import com.taishinlife.tecm.model.entity.ActGeProperty;

public interface ActGePropertyService {
    Optional<ActGeProperty> getActGeProperty(String name);
    ActGeProperty saveActGeProperty(ActGeProperty actGeProperty);
    // Add more methods as needed for your application
}