package models;

public abstract class EquipoModel {
    protected String codigoEquipo;
    protected String descripcion;
    protected double tarifaDiaria;
    protected boolean disponible;

    public EquipoModel(String codigoEquipo, String descripcion, double tarifaDiaria, boolean disponible) {
        this.codigoEquipo = codigoEquipo;
        this.descripcion = descripcion;
        this.tarifaDiaria = tarifaDiaria;
        this.disponible = disponible;
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

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void mostrarInformacion() {
        System.out.println("CODIGO_EQUIPO: " + codigoEquipo + " - DESCRIPCION: " + descripcion + " - TARIFA-DIARIA: " + tarifaDiaria + " - DISPONIBLE:" + disponible);
    }

    public abstract double calcularMonto(int dias);

    //multiplica por 100 al valor, luego redondea a 2 decimales y finalmente divide entre 100
    protected double redondear(double valor) {
        return Math.round(valor * 100.0) / 100.0;
    }
}
