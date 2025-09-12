package com.carlos.scheduler.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity @Table(name="appointments")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Appointment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank private String title;
    private String description;

    @NotNull private LocalDateTime startTime;
    @NotNull private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    // se informado, notificamos via POST
    private String webhookUrl;

    @PrePersist
    public void prePersist() {
        if (status == null) status = AppointmentStatus.PENDING;
    }
}

