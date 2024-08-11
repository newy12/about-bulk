package org.example.jpabulksave.repository;

import org.example.jpabulksave.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test,Long> {
}
