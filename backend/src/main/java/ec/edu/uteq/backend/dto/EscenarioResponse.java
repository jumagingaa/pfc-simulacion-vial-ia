package ec.edu.uteq.backend.dto;

public class EscenarioResponse {

    private Long id;
    private String nombre;
    private String descripcion;
    private String tipoVia;
    private Integer nivelDificultad;
    private String clima;
    private String densidadTrafico;

    public EscenarioResponse() {
    }

    public EscenarioResponse(Long id, String nombre, String descripcion,
                             String tipoVia, Integer nivelDificultad,
                             String clima, String densidadTrafico) {
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

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipoVia() {
        return tipoVia;
    }

    public Integer getNivelDificultad() {
        return nivelDificultad;
    }

    public String getClima() {
        return clima;
    }

    public String getDensidadTrafico() {
        return densidadTrafico;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTipoVia(String tipoVia) {
        this.tipoVia = tipoVia;
    }

    public void setNivelDificultad(Integer nivelDificultad) {
        this.nivelDificultad = nivelDificultad;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public void setDensidadTrafico(String densidadTrafico) {
        this.densidadTrafico = densidadTrafico;
    }
}