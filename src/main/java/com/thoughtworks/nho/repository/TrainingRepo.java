package com.thoughtworks.nho.repository;

import com.thoughtworks.nho.domain.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingRepo extends JpaRepository<Training, Long> {
    List<Training> findByTitle(String title);
}
