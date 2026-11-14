package views;

import services.DatabaseConnector;

import java.util.Scanner;

public class MainView {
    private final Scanner scanner = new Scanner(System.in);

    public void ejecutar() {
        boolean ejecutando = true;
        int opcion;
        while (ejecutando) {
            System.out.println("\n1. Administrar clientes" +
                    "\n2. Administrar la tabla EMPLEADOS" +
                    "\n3. Administrar la tabla VENTA" +
                    "\n4. Salir");
            System.out.print("Ingresa una opcion: ");
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 1:
                    ClienteView clienteView = new ClienteView();
                    clienteView.ejecutar();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    System.out.println("Finalizando programa");
                    ejecutando = false;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }

        }
    }
}
