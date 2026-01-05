package org.example.spring_practis.repository;

import org.example.spring_practis.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
}
