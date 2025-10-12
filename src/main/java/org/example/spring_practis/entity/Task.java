package org.example.spring_practis.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "laguage_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_task_language"))
    private CompilerLanguage language;
    private String name;
    private String description;

    @Column(name = "task_order")
    private int order;
    private LocalDateTime createdAt;
}
