package com.example.demo.repository;

import jakarta.persistence.Id;
import org.springframework.data.repository.CrudRepository;

public interface HistoryRepository extends CrudRepository<OperationsEntity, Long> {

}
