package ec.edu.uteq.backend.dto;

import java.time.LocalDateTime;

public class SimulacionRequest {

    private Long usuarioId;
    private Long escenarioId;
    private LocalDateTime fechaInicio;

    public SimulacionRequest() {
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getEscenarioId() {
        return escenarioId;
    }

    public void setEscenarioId(Long escenarioId) {
        this.escenarioId = escenarioId;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}