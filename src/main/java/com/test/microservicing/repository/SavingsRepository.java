package com.test.microservicing.repository;

import com.test.microservicing.dao.Savings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingsRepository extends JpaRepository<Savings, Long> {
}
