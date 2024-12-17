package com.example.sem8.model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Имя", nullable = false)
    private String name;

    @Column(name = "День рождения", nullable = false)
    private LocalDate birthday;

    @Column(name = "СП", nullable = false)
    private String married;
}
