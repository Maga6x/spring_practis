package org.example.spring_practis.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "compiler_languages")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompilerLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long compilerId;
    private LocalDateTime createdAt;
}
