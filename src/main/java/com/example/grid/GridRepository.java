package com.example.grid;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GridRepository extends JpaRepository<GridRequest, Long> {
}