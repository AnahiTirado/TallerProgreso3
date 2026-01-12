package abstractas.interfaz;

import abstractas.utilitario.Util;

import java.util.Scanner;

import java.util.Scanner;

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

            try {
                opc = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opcion invalida. Ingrese un numero.");
                continue;
            }

            switch (opc) {

                case 1:
                    try {
                        System.out.print("\nIngrese la cedula del empleado: ");
                        cedula = sc.nextLine();
                        System.out.print("Ingrese el nombre del empleado: ");
                        nombre = sc.nextLine();

                        u.agregarEmpleados(cedula, nombre);
                    } catch (Exception e) {
                        System.out.println("Error al agregar empleado: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        System.out.print("\nIngrese la cedula del empleado: ");
                        cedula = sc.nextLine();
                        System.out.print("Ingrese el nivel de seguridad: ");
                        nivelSeguridad = Integer.parseInt(sc.nextLine());
                        System.out.print("Ingrese el Token: ");
                        token = sc.nextLine();

                        u.agregarMetodoAuthToken(cedula, nivelSeguridad, token);
                    } catch (NumberFormatException e) {
                        System.out.println("El nivel de seguridad debe ser un numero.");
                    } catch (Exception e) {
                        System.out.println("Error al agregar autenticacion Token: " + e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        System.out.print("\nIngrese la cedula del empleado: ");
                        cedula = sc.nextLine();
                        System.out.print("Ingrese el nivel de seguridad: ");
                        nivelSeguridad = Integer.parseInt(sc.nextLine());
                        System.out.print("Ingrese el Patron Facial: ");
                        patronRostro = sc.nextLine();

                        u.agregarMetodoAuthFacial(cedula, nivelSeguridad, patronRostro);
                    } catch (NumberFormatException e) {
                        System.out.println("El nivel de seguridad debe ser un numero.");
                    } catch (Exception e) {
                        System.out.println("Error al agregar autenticacion Facial: " + e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        System.out.print("\nIngrese la cedula del empleado: ");
                        cedula = sc.nextLine();
                        System.out.print("Ingrese el nivel de seguridad: ");
                        nivelSeguridad = Integer.parseInt(sc.nextLine());
                        System.out.print("Ingrese el Patron de Huella: ");
                        patronHuella = sc.nextLine();

                        u.agregarMetodoAuthHuella(cedula, nivelSeguridad, patronHuella);
                    } catch (NumberFormatException e) {
                        System.out.println("El nivel de seguridad debe ser un numero.");
                    } catch (Exception e) {
                        System.out.println("Error al agregar autenticacion de Huella: " + e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        System.out.println(u.getEmpleados());
                    } catch (Exception e) {
                        System.out.println("Error al mostrar empleados.");
                    }
                    break;

                case 6:
                    try {
                        System.out.print("\nIngrese la cedula del empleado a buscar: ");
                        cedula = sc.nextLine();

                        int indice = u.buscarEmpleado(cedula);
                        if (indice != -1) {
                            System.out.println("\n--- DATOS DEL EMPLEADO ---");
                            System.out.println(u.getEmpleados().get(indice));
                        } else {
                            System.out.println("Empleado no existe");
                        }
                    } catch (Exception e) {
                        System.out.println("Error al buscar empleado.");
                    }
                    break;

                case 7:
                    try {
                        System.out.print("\nIngrese la cedula del empleado: ");
                        cedula = sc.nextLine();
                        System.out.println(u.cantidadAuthTotal(cedula));
                    } catch (Exception e) {
                        System.out.println("Error al contar autenticaciones.");
                    }
                    break;

                case 8:
                    try {
                        System.out.print("\nIngrese la cedula del empleado: ");
                        cedula = sc.nextLine();
                        System.out.println(u.cantidadAuthHuella(cedula));
                    } catch (Exception e) {
                        System.out.println("Error al contar huellas.");
                    }
                    break;

                case 9:
                    try {
                        System.out.print("\nIngrese la cedula del empleado: ");
                        cedula = sc.nextLine();
                        System.out.println(u.cantidadAuthToken(cedula));
                    } catch (Exception e) {
                        System.out.println("Error al contar tokens.");
                    }
                    break;

                case 10:
                    try {
                        System.out.print("\nIngrese la cedula del empleado: ");
                        cedula = sc.nextLine();
                        System.out.println(u.cantidadAuthRostro(cedula));
                    } catch (Exception e) {
                        System.out.println("Error al contar autenticaciones faciales.");
                    }
                    break;

                case 11:
                    try {
                        System.out.print("\nIngrese la cedula del empleado: ");
                        cedula = sc.nextLine();
                        System.out.print("Ingrese el umbral (nivel de seguridad): ");
                        nivelSeguridad = Integer.parseInt(sc.nextLine());

                        System.out.println(u.authMayorSeguridad(cedula, nivelSeguridad));
                    } catch (NumberFormatException e) {
                        System.out.println("El nivel de seguridad debe ser un numero.");
                    } catch (Exception e) {
                        System.out.println("Error al buscar autenticacion de mayor seguridad.");
                    }
                    break;

                case 12:
                    try {
                        System.out.print("Ingrese el tipo de autenticacion: ");
                        tipo = sc.nextLine();
                        System.out.print("Ingrese el dato: ");
                        dato = sc.nextLine();
                        System.out.print("\nIngrese la cedula del empleado: ");
                        cedula = sc.nextLine();

                        System.out.println(u.autenticarStr(tipo, dato, cedula));
                    } catch (Exception e) {
                        System.out.println("Error en la autenticacion.");
                    }
                    break;

                case 13:
                    System.out.println("Saliendo del Programa...");
                    break;

                default:
                    System.out.println("Opcion Invalida. Ingrese Nuevamente");
            }

        } while (opc != 13);

        sc.close();
    }
}


