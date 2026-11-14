package views;


import controllers.TipoController;

import java.util.Scanner;

public class TipoView {
    private final TipoController tipoController = new TipoController();
    private final Scanner scanner = new Scanner(System.in);

    public void ejecutar() {
        boolean ejecutando = true;
        int opcion;
        while (ejecutando) {
            System.out.println("\n1. Consultar tipos" +
                    "\n2. Registrar tipo" +
                    "\n3. Buscar un tipo" +
                    "\n4. Actualizar tipo" +
                    "\n5. Eliminar tipo" +
                    "\n6. Regresar al menu principal");
            System.out.print("Ingresa una opcion: ");
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 1:
                    tipoController.mostrarTodos();
                    break;
                case 2:
                    registrarTipo();
                    break;
                case 3:
                    buscarTipo();
                    break;
                case 4:
                    actualizarTipo();
                    break;
                case 5:
                    eliminarTipo();
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

    private void registrarTipo() {
        System.out.print("\nIngrese el identificador del tipo a registrar: ");
        String idTipo = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        tipoController.registrar(idTipo, nombre);
    }

    private void buscarTipo() {
        System.out.print("\nIngrese el identificador del tipo a buscar: ");
        String idTipoBuscado = scanner.nextLine();
        tipoController.mostrarTipoPorCodigo(idTipoBuscado);
    }

    private void actualizarTipo() {
        System.out.print("\nIngrese el identificador del tipo a actualizar: ");
        String idTipoActualizar = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        tipoController.actualizarTipo(idTipoActualizar, nombre);
    }

    private void eliminarTipo() {
        System.out.print("\nIngrese el identificador del tipo a eliminar: ");
        String idTipoEliminar = scanner.nextLine();
        tipoController.eliminarTipo(idTipoEliminar);
    }

}
