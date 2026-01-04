package MainVehiculo;

import negocio.Propietario;
import negocio.Vehiculo;
import util.Utilitario;

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

        int opc=0;

        do {
            u.menu();
            opc = Integer.parseInt(sc.nextLine());
            switch (opc) {
                case 1: {
                    System.out.println("Ingrese cedula: ");
                    cedula = sc.nextLine();
                    System.out.println("Ingrese su nombre: ");
                    nombre = sc.nextLine();
                    System.out.println("Ingrese su telefono: ");
                    telefono = sc.nextLine();

                    u.agregarPropietario(cedula, nombre, telefono);
                }
                break;
                case 2: {
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

                }
                break;
                case 3: {
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

                }
                break;
                case 4: {
                    System.out.println("Ingresa la marca: ");
                    marca = sc.nextLine();

                    List<Vehiculo> bm = u.buscarVehiculoMarca(marca);
                    for (Vehiculo v : bm) {
                        System.out.println(bm);
                    }

                }
                break;
                case 5: {
                    System.out.println("==Listado de Vehiculos==");
                    System.out.println(u.listarVehiculos());
                }
                break;
                case 6: {
                    System.out.println("==Listado de Propietarios==");
                    System.out.println(u.listaPropietarios());

                }
                break;
                case 7: {
                    System.out.println("==Listado de Automoviles==");
                    System.out.println(u.listarAutomoviles());
                }
                break;
                case 8: {
                    System.out.println("Ingrese la marca de la motocicleta a buscar: ");
                    marca = sc.nextLine();
                    System.out.println(u.listarNombreAnioArranqueMotoMarca(marca));
                }
                break;
                case 9: {
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
                }
                break;
                case 10: {
                    System.out.println("Saliendo del sistema...");
                }
                break;
                default:{
                    System.out.println("Opcion invalida, intentelo nuevamente");
                }
            }
        }while (opc != 10);
    }
}

