package com.example.grid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GridService {

    @Autowired
    private GridRepository repo;

    @Transactional
    public GridRequest saveRequest(GridRequest req) {
        return repo.save(req);  // Return the saved entity (with generated ID)
    }
}