package views;

import controllers.ClienteController;

import java.util.Scanner;

public class ClienteView {
    private final ClienteController clienteController = new ClienteController();
    private final Scanner scanner = new Scanner(System.in);

    public void ejecutar() {
        boolean ejecutando = true;
        int opcion;
        while (ejecutando) {
            System.out.println("\n1. Consultar clientes" +
                    "\n2. Registrar cliente" +
                    "\n3. Buscar un cliente" +
                    "\n4. Buscar clientes por una parte del nombre" +
                    "\n5. Actualizar cliente" +
                    "\n6. Eliminar cliente" +
                    "\n7. Regresar al menu principal");
            System.out.print("Ingresa una opcion: ");
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 1:
                    clienteController.mostrarTodos();
                    break;
                case 2:
                    registrarCliente();
                    break;
                case 3:
                    buscarCliente();
                    break;
                case 4:
                    buscarClientesPorFragmento();
                    break;
                case 5:
                    actualizarCliente();
                    break;
                case 6:
                    eliminarCliente();
                    break;
                case 7:
                    System.out.println("Regresando al menu principal");
                    ejecutando = false;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        }
    }

    private void registrarCliente() {
        System.out.print("\nDocumento: ");
        String documento = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Telefono: ");
        String telefono = scanner.nextLine();
        clienteController.registrar(documento, nombre, telefono);
    }

    private void buscarCliente() {
        System.out.print("\nIngrese el documento del cliente a buscar: ");
        String documentoClienteBuscado = scanner.nextLine();
        clienteController.mostrarClientePorCodigo(documentoClienteBuscado);
    }

    private void actualizarCliente() {
        System.out.print("\nIngrese el documento del cliente a actualizar: ");
        String documentoClienteActualizar = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Telefono: ");
        String telefono = scanner.nextLine();
        clienteController.actualizarCliente(documentoClienteActualizar, nombre, telefono);
    }

    private void eliminarCliente() {
        System.out.print("\nIngrese el docuemnto del cliente a eliminar: ");
        String documentoClienteEliminar = scanner.nextLine();
        clienteController.eliminarCliente(documentoClienteEliminar);
    }

    private void buscarClientesPorFragmento(){
        System.out.print("Fragmento del nombre de clientes a buscar: ");
        String fragmentoNombre = scanner.nextLine();
        clienteController.mostrarClientesPorFragmento(fragmentoNombre);
    }
}
