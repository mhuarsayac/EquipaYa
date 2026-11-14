package controllers;

import dao.TipoDAO;
import dao.impl.TipoDAOImpl;
import models.TipoModel;

public class TipoController {
    private final TipoDAO tipoDAO = new TipoDAOImpl();

    public void registrar(String idTipo, String nombre) {
        TipoModel t = new TipoModel(idTipo, nombre);
        if (tipoDAO.insertar(t)) {
            System.out.println("Tipo registrado.");
        } else {
            System.out.println("No se pudo registrar el tipo.");
        }
    }

    public void mostrarTodos() {
        for (TipoModel t : tipoDAO.listarTodos()) {
            t.mostrarInformacion();
        }
    }

    public void mostrarTipoPorCodigo(String idTipo) {
        TipoModel tipoBuscado = tipoDAO.buscarPorCodigo(idTipo);
        if (tipoBuscado != null) {
            tipoBuscado.mostrarInformacion();
        } else {
            System.out.println("No se pudo encontrar el tipo");
        }
    }

    public void actualizarTipo(String idTipo, String nombre) {
        TipoModel tipoActualizable = tipoDAO.buscarPorCodigo(idTipo);
        if (tipoActualizable != null) {
            System.out.println("El tipo fue encontrado");
            tipoActualizable.setNombre(nombre);
            tipoActualizable.setNombre(nombre);
            if (tipoDAO.actualizar(tipoActualizable)) {
                System.out.println("El tipo fue actualizado");
            } else {
                System.out.println("El tipo no fue actualizado");
            }
        } else {
            System.out.println("No se pudo encontrar el tipo");
        }
    }

    public void eliminarTipo(String idTipo) {
        if (tipoDAO.eliminar(idTipo)) {
            System.out.println("Se elimino el tipo");
        } else {
            System.out.println("No se elimino el tipo");
        }
    }
}
