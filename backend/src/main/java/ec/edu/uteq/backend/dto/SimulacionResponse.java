package ec.edu.uteq.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SimulacionResponse {

    private Long id;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private String estado;
    private BigDecimal puntajeFinal;

    public SimulacionResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getPuntajeFinal() {
        return puntajeFinal;
    }

    public void setPuntajeFinal(BigDecimal puntajeFinal) {
        this.puntajeFinal = puntajeFinal;
    }
}