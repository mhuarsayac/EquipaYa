package models;

public class EquipoCamaraModel extends EquipoModel {
    private static final double PORCENTAJE_SEGURO = 15;

    public EquipoCamaraModel(String codigoEquipo, String descripcion, double tarifaDiaria, boolean disponible) {
        super(codigoEquipo, descripcion, tarifaDiaria, disponible);
    }

    //falta validar que los dias > 0
    @Override
    public double calcularMonto(int dias) {
        double subtotal = tarifaDiaria * dias;
        double seguroCalculado = subtotal * PORCENTAJE_SEGURO / 100;
        return redondear(subtotal + seguroCalculado);
    }
}
