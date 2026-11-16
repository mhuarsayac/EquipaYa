package models;

public class AlquilerModel {
    private int id_alquiler;
    private String documento;
    private String codigo_equipo;
    private String fecha_inicio;
    private int numero_dias;
    private double monto_cobrado;
    private String devuelto;

    public AlquilerModel(int id_alquiler, String documento, String fecha_inicio, String codigo_equipo, int numero_dias, double monto_cobrado, String devuelto) {
        this.id_alquiler = id_alquiler;
        this.documento = documento;
        this.fecha_inicio = fecha_inicio;
        this.codigo_equipo = codigo_equipo;
        this.numero_dias = numero_dias;
        this.monto_cobrado = monto_cobrado;
        this.devuelto = devuelto;
    }

    public int getId_alquiler() {
        return id_alquiler;
    }

    public void setId_alquiler(int id_alquiler) {
        this.id_alquiler = id_alquiler;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCodigo_equipo() {
        return codigo_equipo;
    }

    public void setCodigo_equipo(String codigo_equipo) {
        this.codigo_equipo = codigo_equipo;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public int getNumero_dias() {
        return numero_dias;
    }

    public void setNumero_dias(int numero_dias) {
        this.numero_dias = numero_dias;
    }

    public double getMonto_cobrado() {
        return monto_cobrado;
    }

    public void setMonto_cobrado(double monto_cobrado) {
        this.monto_cobrado = monto_cobrado;
    }

    public String getDevuelto() {
        return devuelto;
    }

    public void setDevuelto(String devuelto) {
        this.devuelto = devuelto;
    }

    public void mostrarInformacion() {
        System.out.println("+--------------------------------------+");
        System.out.println("  ID: " + id_alquiler);
        System.out.println("  Documento: " + documento);
        System.out.println("  Equipo: " + codigo_equipo);
        System.out.println("  Fecha: " + fecha_inicio);
        System.out.println("  Dias: " + numero_dias);
        System.out.println("  Monto: " + monto_cobrado);
        System.out.println("  Devuelto: " + devuelto);
        System.out.println("+--------------------------------------+");
    }


}
