package interfaz;

import negocio.*;
import util.Utilitario;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Utilitario u = new Utilitario();

        int opc=0;
        do {
            System.out.println("\n---Gestor de Proveedores Digitales---");
            System.out.println("1. Crear proveedor (Cloud - SaaS - Pasarelas de Pago)");
            System.out.println("2. Crear cliente empresarial");
            System.out.println("3. Asociar proveedor a un cliente");
            System.out.println("4. Crear contrato entre proveedor y cliente");
            System.out.println("5. Verificar si un cliente posee proveedores de un tipo determinado");
            System.out.println("6. Listar todos los contratos activos del sistema");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opcion: ");

            String opcion = sc.nextLine();
            try {
                opc = Integer.parseInt(opcion);
            } catch (NumberFormatException e) {
                opc = -1;
            }

            switch (opc) {

                case 1: {
                    try {
                        System.out.println("\n===CREAR PROVEEDOR===");
                        System.out.println("1. Cloud");
                        System.out.println("2. SaaS");
                        System.out.println("3. Pasarela Pago");
                        System.out.print("Seleccione el tipo: ");

                        int tipoP = Integer.parseInt(sc.nextLine());

                        if (tipoP < 1 || tipoP > 3) {
                            System.out.println("Tipo inválido.");
                            break;
                        }

                        System.out.print("Ingrese nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Ingrese país: ");
                        String pais = sc.nextLine();

                        u.crearProveedor(tipoP, nombre, pais);
                        System.out.println("Proveedor creado correctamente.");

                    } catch (NumberFormatException e) {
                        System.out.println("Error: debe ingresar un número válido.");
                    }
                } break;

                case 2: {
                    try {
                        System.out.println("===CREAR CLIENTE EMPRESARIAL===");
                        System.out.print("Nombre de la empresa: ");
                        String nombre = sc.nextLine();

                        u.agregarClienteEmpresa(nombre);
                        System.out.println("Cliente creado correctamente.");

                    } catch (Exception e) {
                        System.out.println("Error al crear el cliente.");
                    }
                } break;

                case 3: {
                    try {
                        System.out.println("===ASOCIAR PROVEEDOR A CLIENTE===");
                        System.out.println(u.listarClientesEmpresa());
                        System.out.print("ID Cliente: ");
                        int idCl = Integer.parseInt(sc.nextLine());

                        System.out.println(u.listarProveedores());
                        System.out.print("ID Proveedor: ");
                        int idPr = Integer.parseInt(sc.nextLine());

                        ClienteEmpresa c = u.getIDClienteEmpresa(idCl);
                        Proveedor p = u.getIDProveedor(idPr);

                        c.contratarProveedor(p);
                        System.out.println("Proveedor asociado correctamente.");

                    } catch (NumberFormatException e) {
                        System.out.println("Debe ingresar números válidos.");
                    } catch (NullPointerException e) {
                        System.out.println("Cliente o proveedor no encontrado.");
                    }
                } break;

                case 4: {
                    try {
                        System.out.println("===CREAR CONTRATO===");
                        System.out.println(u.listarClientesEmpresa());
                        System.out.print("ID Cliente: ");
                        int idCl = Integer.parseInt(sc.nextLine());

                        ClienteEmpresa cl = u.getIDClienteEmpresa(idCl);

                        if (cl.getPrContratados().isEmpty()) {
                            System.out.println("El cliente no tiene proveedores.");
                            break;
                        }

                        int i = 1;
                        for (Proveedor p : cl.getPrContratados()) {
                            System.out.println(i++ + ". " + p);
                        }

                        System.out.print("Seleccione proveedor: ");
                        int idx = Integer.parseInt(sc.nextLine()) - 1;

                        Proveedor pr = cl.getPrContratados().get(idx);

                        System.out.print("Precio: ");
                        double precio = Double.parseDouble(sc.nextLine());

                        System.out.print("Duración (meses): ");
                        int duracion = Integer.parseInt(sc.nextLine());

                        System.out.println(pr.agregarContrato(precio, duracion));

                    } catch (NumberFormatException e) {
                        System.out.println("Formato numérico inválido.");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Proveedor seleccionado no existe.");
                    }
                } break;

                case 5: {
                    try {
                        System.out.println("===VERIFICAR TIPO DE PROVEEDOR===");
                        System.out.println(u.listarClientesEmpresa());
                        System.out.print("ID Cliente: ");
                        int idCl = Integer.parseInt(sc.nextLine());

                        ClienteEmpresa c = u.getIDClienteEmpresa(idCl);

                        System.out.println("1. Cloud\n2. SaaS\n3. Pasarela de pago");
                        int opTipo = Integer.parseInt(sc.nextLine());

                        String tipo = switch (opTipo) {
                            case 1 -> "Cloud";
                            case 2 -> "SaaS";
                            case 3 -> "Pasarelas de pago";
                            default -> null;
                        };

                        if (tipo == null) {
                            System.out.println("Tipo inválido.");
                            break;
                        }

                        System.out.println(
                                c.verificarTipoProveedor(tipo)
                                        ? "SI posee proveedores de tipo " + tipo
                                        : "NO posee proveedores de tipo " + tipo
                        );

                    } catch (NumberFormatException e) {
                        System.out.println("Debe ingresar números válidos.");
                    } catch (NullPointerException e) {
                        System.out.println("Cliente no encontrado.");
                    }
                } break;

                case 6: {
                    try {
                        System.out.println("===CONTRATOS ACTIVOS===");
                        System.out.println(u.listarContratosActivos());
                    } catch (Exception e) {
                        System.out.println("Error al listar contratos.");
                    }
                } break;

                case 7:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        }while(opc != 7);
    }
}
