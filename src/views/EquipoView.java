package views;

import controllers.EquipoController;

import java.util.Scanner;

public class EquipoView {
    private final EquipoController equipoController = new EquipoController();
    private final Scanner scanner = new Scanner(System.in);

    public void ejecutar() {
        boolean ejecutando = true;
        int opcion;
        while (ejecutando) {
            System.out.println("\n1. Consultar equipos" +
                    "\n2. Registrar equipo" +
                    "\n3. Buscar un equipo" +
                    "\n4. Actualizar equipo" +
                    "\n5. Eliminar equipo" +
                    "\n6. Regresar al menu principal");
            System.out.print("Ingresa una opcion: ");
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 1:
                    equipoController.mostrarTodos();
                    break;
                case 2:
                    registrarEquipo();
                    break;
                case 3:
                    buscarEquipo();
                    break;
                case 4:
                    actualizarEquipo();
                    break;
                case 5:
                    eliminarEquipo();
                    break;
                case 6:
                    System.out.println("Regresando al menu principal");
                    ejecutando = false;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        }
    }

    private void registrarEquipo() {
        System.out.print("\nIngrese el codigo del equipo a registrar: ");
        String codigoEquipo = scanner.nextLine();
        System.out.print("Descripcion: ");
        String descripcion = scanner.nextLine();
        System.out.print("Tarifa diaria: ");
        double tarifaDiaria = Double.parseDouble(scanner.nextLine());
        System.out.print("ID del tipo al que pertenece: ");
        String idTipo = scanner.nextLine();
        equipoController.registrar(codigoEquipo, descripcion, tarifaDiaria, idTipo);
    }

    private void buscarEquipo() {
        System.out.print("\nIngrese el codigo del equipo a buscar: ");
        String codigoEquipoBuscado = scanner.nextLine();
        equipoController.mostrarEquipoPorCodigo(codigoEquipoBuscado);
    }

    private void actualizarEquipo() {
        System.out.print("\nIngrese el codigo del equipo a actualizar: ");
        String codigoEquipoActualizar = scanner.nextLine();
        System.out.print("Descripcion: ");
        String descripcion = scanner.nextLine();
        System.out.print("Tarifa diaria: ");
        double tarifaDiaria = Double.parseDouble(scanner.nextLine());
        equipoController.actualizarEquipo(codigoEquipoActualizar, descripcion, tarifaDiaria);
    }

    private void eliminarEquipo() {
        System.out.print("\nIngrese el codigo del equipo a eliminar: ");
        String codigoEquipoEliminar = scanner.nextLine();
        equipoController.eliminarEquipo(codigoEquipoEliminar);
    }
}
