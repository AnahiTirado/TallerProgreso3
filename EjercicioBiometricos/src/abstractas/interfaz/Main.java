package abstractas.interfaz;

import abstractas.utilitario.Util;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Util u = new Util();
        Scanner sc = new Scanner(System.in);

        String cedula;
        String nombre;

        int nivelSeguridad;
        String tipo, dato;
        String token, patronRostro, patronHuella;

        int opc = 0;

        do {
            u.menu();
            opc = Integer.parseInt(sc.nextLine());
            switch (opc) {
                case 1: {
                    System.out.print("\nIngrese la cedula del empleado: ");
                    cedula = sc.nextLine();
                    System.out.print("Ingrese el nombre del empleado: ");
                    nombre = sc.nextLine();

                    u.agregarEmpleados(cedula, nombre);

                } break;
                case 2: {
                    System.out.print("\nIngrese la cedula del empleado: ");
                    cedula = sc.nextLine();
                    System.out.print("Ingrese el nivel de seguridad: ");
                    nivelSeguridad = Integer.parseInt(sc.nextLine());
                    System.out.print("Ingrese el Token: ");
                    token = sc.nextLine();

                    u.agregarMetodoAuthToken(cedula, nivelSeguridad, token);
                } break;
                case 3: {

                    System.out.print("\nIngrese la cedula del empleado: ");
                    cedula = sc.nextLine();
                    System.out.print("Ingrese el nivel de seguridad: ");
                    nivelSeguridad = Integer.parseInt(sc.nextLine());
                    System.out.print("Ingrese el Patron Facial: ");
                    patronRostro = sc.nextLine();

                    u.agregarMetodoAuthFacial(cedula, nivelSeguridad, patronRostro);
                } break;
                case 4: {

                    System.out.print("\nIngrese la cedula del empleado: ");
                    cedula = sc.nextLine();
                    System.out.print("Ingrese el nivel de seguridad: ");
                    nivelSeguridad = Integer.parseInt(sc.nextLine());
                    System.out.print("Ingrese el Patron de Huella: ");
                    patronHuella = sc.nextLine();

                    u.agregarMetodoAuthHuella(cedula, nivelSeguridad, patronHuella);
                } break;
                case 5: {
                    System.out.println(u.getEmpleados());
                } break;
                case 6: {
                    System.out.print("\nIngrese la cedula del empleado a buscar: ");
                    cedula = sc.nextLine();

                    int indice = u.buscarEmpleado(cedula);
                    if (indice != -1) {
                        System.out.println("\n--- DATOS DEL EMPLEADO ---");
                        System.out.println(u.getEmpleados().get(indice));
                    } else {
                        System.out.println("Empleado no Existe");
                    }
                } break;
                case 7: {
                    System.out.print("\nIngrese la cedula del empleado: ");
                    cedula = sc.nextLine();

                    System.out.println(u.cantidadAuthTotal(cedula));
                } break;
                case 8: {
                    System.out.print("\nIngrese la cedula del empleado: ");
                    cedula = sc.nextLine();

                    System.out.println(u.cantidadAuthHuella(cedula));

                } break;
                case 9: {
                    System.out.print("\nIngrese la cedula del empleado: ");
                    cedula = sc.nextLine();

                    System.out.println(u.cantidadAuthToken(cedula));

                } break;
                case 10: {
                    System.out.print("\nIngrese la cedula del empleado: ");
                    cedula = sc.nextLine();

                    System.out.println(u.cantidadAuthRostro(cedula));
                } break;
                case 11: {
                    System.out.print("\nIngrese la cedula del empleado: ");
                    cedula = sc.nextLine();
                    System.out.print("Ingrese el umbral (nivel de seguridad): ");
                    nivelSeguridad = Integer.parseInt(sc.nextLine());

                    System.out.println(u.authMayorSeguridad(cedula, nivelSeguridad));
                } break;
                case 12: {
                    System.out.print("Ingrese el tipo de autenticacion: ");
                    tipo = sc.nextLine();
                    System.out.print("Ingrese el dato: ");
                    dato = sc.nextLine();
                    System.out.print("\nIngrese la cedula del empleado: ");
                    cedula = sc.nextLine();

                    System.out.println(u.autenticarStr(tipo, dato, cedula));
                } break;
                case 13: {
                    System.out.println("Saliendo del Programa...");
                } break;
                default: {
                    System.out.println("Opcion Invalida. Ingrese Nuevamente");
                }
            }
        } while (opc != 13);
    }
}
