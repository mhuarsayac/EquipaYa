package controllers;

import dao.ClienteDAO;
import dao.impl.ClienteDAOImpl;
import models.ClienteModel;

public class ClienteController {
    private final ClienteDAO clienteDAO = new ClienteDAOImpl();

    public void registrar(String documento, String nombre, String telefono) {
        ClienteModel p = new ClienteModel(documento, nombre, telefono);
        if (clienteDAO.insertar(p)) {
            System.out.println("Producto registrado.");
        } else {
            System.out.println("No se pudo registrar al cliente.");
        }
    }

    public void mostrarTodos() {
        for (ClienteModel p : clienteDAO.listarTodos()) {
            p.mostrarInformacion();
        }
    }

    public void mostrarClientePorCodigo(String documento) {
        ClienteModel clienteBuscado = clienteDAO.buscarPorCodigo(documento);
        if (clienteBuscado != null) {
            clienteBuscado.mostrarInformacion();
        } else {
            System.out.println("No se pudo encontrar al cliente");
        }
    }

    public void actualizarCliente(String documento, String nombre, String telefono) {
        ClienteModel clienteActualizable = clienteDAO.buscarPorCodigo(documento);
        if (clienteActualizable != null) {
            System.out.println("El cliente fue encontrado");
            clienteActualizable.setNombre(nombre);
            clienteActualizable.setTelefono(telefono);
            if (clienteDAO.actualizar(clienteActualizable)) {
                System.out.println("El cliente fue actualizado");
            } else {
                System.out.println("El cliente no fue actualizado");
            }
        } else {
            System.out.println("No se pudo encontrar al cliente");
        }
    }

    public void eliminarCliente(String documento) {
        if (clienteDAO.eliminar(documento)) {
            System.out.println("Se elimino al cliente");
        } else {
            System.out.println("No se elimino al cliente");
        }
    }

}
