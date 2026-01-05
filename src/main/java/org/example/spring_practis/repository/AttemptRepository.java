package org.example.spring_practis.repository;

import org.example.spring_practis.entity.Attempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttemptRepository extends JpaRepository<Attempt,Long> {
}
