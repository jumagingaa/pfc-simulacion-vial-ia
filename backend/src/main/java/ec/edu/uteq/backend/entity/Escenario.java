package ec.edu.uteq.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "escenarios")
public class Escenario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(length = 500)
    private String descripcion;

    @Column(nullable = false)
    private String tipoVia;

    @Column(nullable = false)
    private Integer nivelDificultad;

    @Column(nullable = false)
    private String clima;

    @Column(nullable = false)
    private String densidadTrafico;


    public Escenario() {
    }

    public Escenario(Long id, String nombre, String descripcion, String tipoVia,
                     Integer nivelDificultad, String clima,
                     String densidadTrafico, Usuario usuario) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoVia = tipoVia;
        this.nivelDificultad = nivelDificultad;
        this.clima = clima;
        this.densidadTrafico = densidadTrafico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoVia() {
        return tipoVia;
    }

    public void setTipoVia(String tipoVia) {
        this.tipoVia = tipoVia;
    }

    public Integer getNivelDificultad() {
        return nivelDificultad;
    }

    public void setNivelDificultad(Integer nivelDificultad) {
        this.nivelDificultad = nivelDificultad;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getDensidadTrafico() {
        return densidadTrafico;
    }

    public void setDensidadTrafico(String densidadTrafico) {
        this.densidadTrafico = densidadTrafico;
    }

}