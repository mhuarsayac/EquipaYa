package views;

import controllers.AlquilerController;

import java.util.Scanner;

public class AlquilerView {
    private final AlquilerController alquilerController = new AlquilerController();
    private final Scanner scanner = new Scanner(System.in);

    public void ejecutar() {
        boolean ejecutando = true;
        int opcion;
        while (ejecutando) {
            System.out.println("\n1. Consultar alquileres" +
                    "\n2. Registrar alquiler" +
                    "\n3. Buscar un alquiler" +
                    "\n4. Ver pendientes de devolucion" +
                    "\n5. Devolver equipo" +
                    "\n6. Ver facturacion por tipo" +
                    "\n7. Regresar al menu principal");
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 1:
                    alquilerController.mostrarTodoAlquiler();
                    break;
                case 2:
                    registrarAlquiler();
                    break;
                case 3:
                    buscarAlquiler();
                    break;
                case 4:
                    alquilerController.mostrarPendientes();
                    break;
                case 5:
                    devolverEquipo();
                    break;
                case 6:
                    alquilerController.mostrarFacturacion();
                    break;
                case 7:
                    System.out.println("Regresando al menu principal");
                    ejecutando = false;
                    break;
            }
        }
    }

    private void registrarAlquiler() {
        System.out.print("\nDocumento del cliente: ");
        String documento = scanner.nextLine();
        System.out.print("Codigo del equipo: ");
        String codigoEquipo = scanner.nextLine();
        System.out.print("Fecha de inicio (año-mes-dia, ej. 2026-11-15): ");
        String fecha = scanner.nextLine();
        System.out.print("Numero de dias: ");
        int dias = Integer.parseInt(scanner.nextLine());
        alquilerController.registrar(documento, codigoEquipo, fecha, dias);
    }

    private void buscarAlquiler() {
        System.out.print("\nIngrese el id del alquiler a buscar: ");
        String id = scanner.nextLine();
        alquilerController.mostrarAlquilerPorCodigo(id);
    }

    private void devolverEquipo() {
        System.out.print("\nCodigo del equipo a devuelto: ");
        String codigoEquipo = scanner.nextLine();
        alquilerController.devolver(codigoEquipo);
    }
}
