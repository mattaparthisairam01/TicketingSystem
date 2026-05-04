package com.project.TicketingSystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity(name="ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private ModuleType module;
    @Enumerated(EnumType.STRING)
    private CategoryType category;
    private LocalDateTime createdAt;


}
