package controllers;

import dao.EquipoDAO;
import dao.impl.EquipoDAOImpl;
import models.EquipoModel;

public class EquipoController {
    private final EquipoDAO equipoDAO = new EquipoDAOImpl();

    public void registrar(String codigoEquipo, String descripcion, double tarifaDiaria, String disponible, String idTipo) {
        EquipoModel t = new EquipoModel(codigoEquipo, descripcion, tarifaDiaria, disponible, idTipo);
        if (equipoDAO.insertar(t)) {
            System.out.println("Equipo registrado.");
        } else {
            System.out.println("No se pudo registrar el equipo.");
        }
    }

    public void mostrarTodos() {
        for (EquipoModel t : equipoDAO.listarTodos()) {
            t.mostrarInformacion();
        }
    }

    public void mostrarEquipoPorCodigo(String codigoEquipo) {
        EquipoModel equipoBuscado = equipoDAO.buscarPorCodigo(codigoEquipo);
        if (equipoBuscado != null) {
            equipoBuscado.mostrarInformacion();
        } else {
            System.out.println("No se pudo encontrar el equipo");
        }
    }

    public void actualizarEquipo(String codigoEquipo, String descripcion, double tarifaDiaria, String disponible, String idTipo) {
        EquipoModel equipoActualizable = equipoDAO.buscarPorCodigo(codigoEquipo);
        if (equipoActualizable != null) {
            System.out.println("El equipo fue encontrado");
            equipoActualizable.setDescripcion(descripcion);
            equipoActualizable.setTarifaDiaria(tarifaDiaria);
            equipoActualizable.setDisponible(disponible);
            equipoActualizable.setIdTipo(idTipo);
            if (equipoDAO.actualizar(equipoActualizable)) {
                System.out.println("El equipo fue actualizado");
            } else {
                System.out.println("El equipo no fue actualizado");
            }
        } else {
            System.out.println("No se pudo encontrar el equipo");
        }
    }

    public void eliminarEquipo(String codigoEquipo) {
        if (equipoDAO.eliminar(codigoEquipo)) {
            System.out.println("Se elimino el equipo");
        } else {
            System.out.println("No se elimino el equipo");
        }
    }
}
