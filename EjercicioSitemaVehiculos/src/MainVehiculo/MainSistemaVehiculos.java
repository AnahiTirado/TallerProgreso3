package MainVehiculo;

import negocio.Propietario;
import negocio.Vehiculo;
import util.Utilitario;

import java.util.List;
import java.util.Scanner;

import java.util.List;
import java.util.Scanner;

public class MainSistemaVehiculos {
    public static void main(String[] args) {
        Utilitario u = new Utilitario();
        Scanner sc = new Scanner(System.in);

        String marca, modelo;
        int anio;
        String traccion, tipo;

        String cedula, nombre, telefono;

        double altura;
        String arranque;

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
                        System.out.println("Ingrese cedula: ");
                        cedula = sc.nextLine();
                        System.out.println("Ingrese su nombre: ");
                        nombre = sc.nextLine();
                        System.out.println("Ingrese su telefono: ");
                        telefono = sc.nextLine();

                        u.agregarPropietario(cedula, nombre, telefono);
                    } catch (Exception e) {
                        System.out.println("Error al agregar propietario.");
                    }
                    break;

                case 2:
                    try {
                        System.out.println("Ingrese su cedula: ");
                        cedula = sc.nextLine();
                        Propietario p = u.burscarPropietario(cedula);

                        if (p != null) {
                            System.out.println("Ingrese marca: ");
                            marca = sc.nextLine();
                            System.out.println("Ingrese modelo: ");
                            modelo = sc.nextLine();
                            System.out.println("Ingrese anio: ");
                            anio = Integer.parseInt(sc.nextLine());
                            System.out.println("Ingrese traccion: ");
                            traccion = sc.nextLine();
                            System.out.println("Ingrese el tipo: ");
                            tipo = sc.nextLine();

                            u.agregarAuto(marca, modelo, anio, p, traccion, tipo);
                        } else {
                            System.out.println("Propietario No Existe");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("El anio debe ser un numero.");
                    } catch (Exception e) {
                        System.out.println("Error al agregar automovil.");
                    }
                    break;

                case 3:
                    try {
                        System.out.println("Ingrese su cedula: ");
                        cedula = sc.nextLine();
                        Propietario p = u.burscarPropietario(cedula);

                        if (p != null) {
                            System.out.println("Ingrese marca: ");
                            marca = sc.nextLine();
                            System.out.println("Ingrese modelo: ");
                            modelo = sc.nextLine();
                            System.out.println("Ingrese anio: ");
                            anio = Integer.parseInt(sc.nextLine());
                            System.out.println("Ingrese altura: ");
                            altura = Double.parseDouble(sc.nextLine());
                            System.out.println("Ingrese el arranque: ");
                            arranque = sc.nextLine();

                            u.agregarMoto(marca, modelo, anio, p, altura, arranque);
                        } else {
                            System.out.println("Propietario No Existe");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("El anio o la altura tienen formato incorrecto.");
                    } catch (Exception e) {
                        System.out.println("Error al agregar motocicleta.");
                    }
                    break;

                case 4:
                    try {
                        System.out.println("Ingresa la marca: ");
                        marca = sc.nextLine();

                        List<Vehiculo> bm = u.buscarVehiculoMarca(marca);
                        for (Vehiculo v : bm) {
                            System.out.println(v);
                        }
                    } catch (Exception e) {
                        System.out.println("Error al buscar vehiculos por marca.");
                    }
                    break;

                case 5:
                    try {
                        System.out.println("==Listado de Vehiculos==");
                        System.out.println(u.listarVehiculos());
                    } catch (Exception e) {
                        System.out.println("Error al listar vehiculos.");
                    }
                    break;

                case 6:
                    try {
                        System.out.println("==Listado de Propietarios==");
                        System.out.println(u.listaPropietarios());
                    } catch (Exception e) {
                        System.out.println("Error al listar propietarios.");
                    }
                    break;

                case 7:
                    try {
                        System.out.println("==Listado de Automoviles==");
                        System.out.println(u.listarAutomoviles());
                    } catch (Exception e) {
                        System.out.println("Error al listar automoviles.");
                    }
                    break;

                case 8:
                    try {
                        System.out.println("Ingrese la marca de la motocicleta a buscar: ");
                        marca = sc.nextLine();
                        System.out.println(u.listarNombreAnioArranqueMotoMarca(marca));
                    } catch (Exception e) {
                        System.out.println("Error al listar motocicletas por marca.");
                    }
                    break;

                case 9:
                    try {
                        System.out.println("Ingrese su cedula: ");
                        cedula = sc.nextLine();
                        System.out.println("Ingrese marca: ");
                        marca = sc.nextLine();
                        System.out.println("Ingrese el anio: ");
                        anio = Integer.parseInt(sc.nextLine());

                        int valor = u.matricula(cedula, marca, anio);
                        if (valor != -1) {
                            System.out.println("Matriculado. El valor a pagar es: " + valor);
                        } else {
                            System.out.println("No es posible matricular");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("El anio debe ser un numero.");
                    } catch (Exception e) {
                        System.out.println("Error en el proceso de matricula.");
                    }
                    break;

                case 10:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion invalida, intentelo nuevamente");
            }

        } while (opc != 10);

        sc.close();
    }
}


