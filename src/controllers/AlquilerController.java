package controllers;

import dao.AlquilerDAO;
import dao.EquipoDAO;
import dao.impl.AlquilerDAOImpl;
import dao.impl.EquipoDAOImpl;
import models.AlquilerModel;
import models.EquipoModel;

public class AlquilerController {
    final AlquilerDAO alquilerDAO = new AlquilerDAOImpl();
    final EquipoDAO equipoDAO = new EquipoDAOImpl();



    public void registrar(String documento, String codigo_equipo, String fecha_inicio, int numero_dias){

        EquipoModel equipo = equipoDAO.buscarPorCodigo(codigo_equipo);

        if(equipo == null){
            System.out.println("El equipo no existe");
            return;
        }
        if (equipo.getDisponible().equals("S")==false){
            System.out.println("El equipo no se puede disponible");
            return;
        }

        double montocobrado = equipo.calcularMonto(numero_dias);

        AlquilerModel alquilerModel = new AlquilerModel(0,documento,fecha_inicio,codigo_equipo,numero_dias,montocobrado,"N");

        if (alquilerDAO.insertar(alquilerModel)) {
            equipo.setDisponible("N");
            equipoDAO.actualizar(equipo);
            System.out.println("Alquiler registrado exitosamente");
        } else {
            System.out.println("No se pudo registrar alquiler");
        }
    }

    public void mostrarTodoAlquiler(){
        for (AlquilerModel a: alquilerDAO.listarTodos()){
            a.mostrarInformacion();
        }
    }

    public void mostrarAlquilerPorCodigo(String id){
        AlquilerModel alquiler = alquilerDAO.buscarPorCodigo(id);
        if (alquiler != null) {
            alquiler.mostrarInformacion();
        } else {
            System.out.println("No se pudo encontrar el alquiler");
        }
    }

    public void mostrarPendientes() {
        for (AlquilerModel a : alquilerDAO.pendientes()) {
            a.mostrarInformacion();
        }
    }

    public void devolver(String codigoEquipo) {
        if (alquilerDAO.devolver(codigoEquipo)) {
            EquipoModel equipo = equipoDAO.buscarPorCodigo(codigoEquipo);
            if (equipo != null) {
                equipo.setDisponible("S");        // el equipo queda libre otra vez
                equipoDAO.actualizar(equipo);
            }
            System.out.println("Equipo devuelto correctamente");
        } else {
            System.out.println("Ese equipo no tiene un alquiler pendiente");
        }
    }



}
