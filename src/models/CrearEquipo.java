package models;

public class CrearEquipo {
    public static EquipoModel crear(String codigoEquipo, String descripcion, double tarifa, String disponible, String idTipo) {
        if (idTipo == null) {
            return null;
        }
        switch (idTipo) {
            case "TE1":
                return new EquipoCamaraModel(codigoEquipo, descripcion, tarifa, disponible, idTipo);
            case "TE2":
                return new EquipoIluminacionModel(codigoEquipo, descripcion, tarifa, disponible, idTipo);
            case "TE3":
                return new EquipoAudioModel(codigoEquipo, descripcion, tarifa, disponible, idTipo);
            default:
                return null;
        }
    }
}
