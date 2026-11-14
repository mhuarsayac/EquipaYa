package models;

public class TipoModel {
    private String idTipo;
    private String nombre;

    public TipoModel(String idTipo, String nombre) {
        this.idTipo = idTipo;
        this.nombre = nombre;
    }

    public String getIdTipo() {
        return idTipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void mostrarInformacion() {
        System.out.println("ID_TIPO: " + idTipo + " - NOMBRE: " + nombre);
    }
}
