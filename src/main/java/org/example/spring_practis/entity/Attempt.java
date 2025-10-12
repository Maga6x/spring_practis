package org.example.spring_practis.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "attempts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Attempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "task_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_attempt_task"))
    private Task task;

    @Column(name = "answer_code", columnDefinition = "text")
    private String answerCode;

    @Column(name = "passed_tests", columnDefinition = "text")
    private String passedTests;

    @Column(name = "failed_tests", columnDefinition = "text")
    private String failedTests;

    @Column(name = "total_mark", nullable = false)
    private double totalMark;

    @Column(nullable=false, updatable=false)
    private LocalDateTime createdAt;
}
