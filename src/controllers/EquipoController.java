package controllers;

import dao.EquipoDAO;
import dao.impl.EquipoDAOImpl;
import models.CrearEquipo;
import models.EquipoModel;

public class EquipoController {
    private final EquipoDAO equipoDAO = new EquipoDAOImpl();

    public void registrar(String codigoEquipo, String descripcion, double tarifaDiaria, String idTipo) {
        EquipoModel equipo = CrearEquipo.crear(codigoEquipo, descripcion, tarifaDiaria, "S", idTipo);
        if (equipo == null) {
            System.out.println("Tipo de equipo no valido: " + idTipo);
            return;
        }

        if (equipoDAO.insertar(equipo)) {
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

    public void actualizarEquipo(String codigoEquipo, String descripcion, double tarifaDiaria) {
        EquipoModel equipoActualizable = equipoDAO.buscarPorCodigo(codigoEquipo);
        if (equipoActualizable != null) {
            System.out.println("El equipo fue encontrado");
            equipoActualizable.setDescripcion(descripcion);
            equipoActualizable.setTarifaDiaria(tarifaDiaria);
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
