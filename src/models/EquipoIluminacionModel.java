package models;

public class EquipoIluminacionModel extends EquipoModel{
    private static final int PORCENTAJE_DESCUENTO = 15;

    public EquipoIluminacionModel(String codigoEquipo, String descripcion, double tarifaDiaria, boolean disponible, String idTipo) {
        super(codigoEquipo, descripcion, tarifaDiaria, disponible, idTipo);
    }

    @Override
    public double calcularMonto(int dias) {
        double subtotal = tarifaDiaria * dias;
        double descuentoCalculado = 0;
        if (dias > 5) {
            descuentoCalculado = subtotal * PORCENTAJE_DESCUENTO / 100;
        }
        return redondear(subtotal - descuentoCalculado);
    }
}
