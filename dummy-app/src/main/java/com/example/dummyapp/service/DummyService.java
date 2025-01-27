package com.example.dummyapp.service;

import com.example.dummyapp.entity.Dummy;
import com.example.dummyapp.repository.DummyRepository;
import org.springframework.stereotype.Service;

@Service
public class DummyService {

    private final DummyRepository dummyRepository;

    public DummyService(DummyRepository dummyRepository) {
        this.dummyRepository = dummyRepository;
    }

    public Dummy saveDummy(String description) {
        Dummy dummy = new Dummy();
        dummy.setDescription(description);
        return dummyRepository.save(dummy);
    }
}
