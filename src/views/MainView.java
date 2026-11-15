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
                    "\n2. Administrar tipos de equipos" +
                    "\n3. Administrar equipos" +
                    "\n4. Administrar arquileres" +
                    "\n5. Salir");
            System.out.print("Ingresa una opcion: ");
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 1:
                    ClienteView clienteView = new ClienteView();
                    clienteView.ejecutar();
                    break;
                case 2:
                    TipoView tipoView = new TipoView();
                    tipoView.ejecutar();
                    break;
                case 3:
                    EquipoView equipoView = new EquipoView();
                    equipoView.ejecutar();
                    break;
                case 4:

                    break;
                case 5:
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
