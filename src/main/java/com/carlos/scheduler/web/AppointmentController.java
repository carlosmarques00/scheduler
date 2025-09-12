package com.carlos.scheduler.web;

import com.carlos.scheduler.domain.Appointment;
import com.carlos.scheduler.service.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService service;

    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    // 👉 LISTAR TODOS
    @GetMapping
    public List<Appointment> getAllAppointments() {
        return service.getAllAppointments();
    }

    // 👉 CRIAR NOVO
    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return service.save(appointment);
    }
}

