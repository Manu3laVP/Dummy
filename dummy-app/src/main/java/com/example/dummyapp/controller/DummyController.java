package com.example.dummyapp.controller;

import com.example.dummyapp.entity.Dummy;
import com.example.dummyapp.service.DummyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dummy")
public class DummyController {

    private final DummyService dummyService;

    public DummyController(DummyService dummyService) {
        this.dummyService = dummyService;
    }

    @PostMapping
    public ResponseEntity<Dummy> createDummy(@RequestBody Dummy dummyRequest) {
        if (dummyRequest.getDescription() == null || dummyRequest.getDescription().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        Dummy savedDummy = dummyService.saveDummy(dummyRequest.getDescription());
        return ResponseEntity.ok(savedDummy);
    }
}
