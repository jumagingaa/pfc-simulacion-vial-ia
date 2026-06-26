package ec.edu.uteq.backend.dto;

public class EscenarioRequest {

    private String nombre;
    private String descripcion;
    private String tipoVia;
    private Integer nivelDificultad;
    private String clima;
    private String densidadTrafico;

    public EscenarioRequest() {
    }

    public EscenarioRequest(String nombre, String descripcion, String tipoVia,
                            Integer nivelDificultad, String clima,
                            String densidadTrafico) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoVia = tipoVia;
        this.nivelDificultad = nivelDificultad;
        this.clima = clima;
        this.densidadTrafico = densidadTrafico;
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