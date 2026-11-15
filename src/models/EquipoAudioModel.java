package models;

public class EquipoAudioModel extends EquipoModel {
    private static final int MINIMO_DIAS = 2;

    public EquipoAudioModel(String codigoEquipo, String descripcion, double tarifaDiaria, boolean disponible) {
        super(codigoEquipo, descripcion, tarifaDiaria, disponible);
    }

    @Override
    public double calcularMonto(int dias) {
        double subtotal;
        if (dias < MINIMO_DIAS) {
            subtotal = tarifaDiaria * MINIMO_DIAS;
        } else {
            subtotal = tarifaDiaria * dias;
        }
        return redondear(subtotal);
    }
}
