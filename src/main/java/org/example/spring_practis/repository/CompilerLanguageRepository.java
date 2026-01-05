package org.example.spring_practis.repository;

import org.example.spring_practis.entity.CompilerLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompilerLanguageRepository extends JpaRepository<CompilerLanguage,Long> {
}
