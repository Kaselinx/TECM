package com.taishinlife.tecm.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taishinlife.tecm.model.entity.ActGeProperty;
import com.taishinlife.tecm.provider.repository.ActGePropertyRepository;

@Service
public class ActGePropertyServiceImpl implements ActGePropertyService {

    private final ActGePropertyRepository repository;

    @Autowired
    public ActGePropertyServiceImpl(ActGePropertyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<ActGeProperty> getActGeProperty(String name) {
        return repository.findById(name);
    }

	@Override
	public ActGeProperty saveActGeProperty(ActGeProperty actGeProperty) {
		// TODO Auto-generated method stub
		 return repository.save(actGeProperty);
	}

}