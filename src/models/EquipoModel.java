package models;

public abstract class EquipoModel {
    protected String codigoEquipo;
    protected String descripcion;
    protected double tarifaDiaria;
    protected String disponible;
    protected String idTipo;

    public EquipoModel(String codigoEquipo, String descripcion, double tarifaDiaria, String disponible, String idTipo) {
        this.codigoEquipo = codigoEquipo;
        this.descripcion = descripcion;
        this.tarifaDiaria = tarifaDiaria;
        this.disponible = disponible;
        this.idTipo = idTipo;
    }

    public String getCodigoEquipo() {
        return codigoEquipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getTarifaDiaria() {
        return tarifaDiaria;
    }

    public void setTarifaDiaria(double tarifaDiaria) {
        this.tarifaDiaria = tarifaDiaria;
    }

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    public String getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(String idTipo) {
        this.idTipo = idTipo;
    }

    public void mostrarInformacion() {
        System.out.println("CODIGO_EQUIPO: " + codigoEquipo + " - DESCRIPCION: " + descripcion + " - TARIFA-DIARIA: " + tarifaDiaria + " - DISPONIBLE: " + disponible + " - ID_TIPO: " + idTipo);
    }

    public abstract double calcularMonto(int dias);

    //multiplica por 100 al valor, luego redondea a 2 decimales y finalmente divide entre 100
    protected double redondear(double valor) {
        return Math.round(valor * 100.0) / 100.0;
    }
}
