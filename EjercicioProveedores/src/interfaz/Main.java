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

            switch (opc){
                case 1: {
                    System.out.println("\n===CREAR PROVEEDOR===");
                    System.out.println("Tipos de proveedores:");
                    System.out.println("1. Cloud");
                    System.out.println("2. SaaS");
                    System.out.println("3. Pasarela Pago");
                    System.out.print("Seleccione el tipo a crear (1-3): ");

                    int tipoP;
                    String tipoPEntrada = sc.nextLine();
                    try {
                        tipoP = Integer.parseInt(tipoPEntrada);
                    } catch (NumberFormatException e) {
                        tipoP = -1;
                    }
                    if (tipoP < 1 || tipoP > 3) {
                        System.out.println("Tipo invalido. No se creo el proveedor.");
                        break;
                    }

                    System.out.print("Ingrese el nombre del proveedor: ");
                    String nombre = sc.nextLine();

                    System.out.print("Ingrese el pais del proveedor: ");
                    String pais = sc.nextLine();
                    u.crearProveedor(tipoP, nombre, pais);

                } break;
                case 2: {
                    System.out.println("===CREAR CLIENTE EMPRESARIAL===");
                    System.out.println("Ingrese el nombre de la empresa que desee agregar: ");
                    String nombre = sc.nextLine();
                    u.agregarClienteEmpresa(nombre);

                } break;
                case 3: {
                    int idCl, idPr;
                    System.out.println("===ASOCIAR PROOVEDOR A UN CLIENTE===");
                    System.out.println(u.listarClientesEmpresa());
                    System.out.print("Ingrese el numero de Cliente: ");
                    idCl = Integer.parseInt(sc.nextLine());

                    System.out.println(u.listarProveedores());
                    System.out.print("Ingrese el numero de Proveedor a contratar: ");
                    idPr = Integer.parseInt(sc.nextLine());

                    ClienteEmpresa c = u.getIDClienteEmpresa(idCl);
                    Proveedor p = u.getIDProveedor(idPr);
                    c.contratarProveedor(p);

                } break;
                case 4: {
                    int idCl;
                    double precio;
                    int duracionEnMeses;
                    System.out.println("===CONTRATO PROVEEDOR-CLIENTE===");
                    System.out.println(u.listarClientesEmpresa());
                    System.out.print("Ingrese el numero de Proveedor para crear su contrato: ");
                    idCl = Integer.parseInt(sc.nextLine());

                    ClienteEmpresa cl = u.getIDClienteEmpresa(idCl);
                    List<Proveedor> provCl = cl.getPrContratados();
                    if (provCl.isEmpty()) {
                        System.out.println("Este cliente no tiene proveedores asociados.");
                        System.out.println("Use la opcion 3 para asociar un proveedor al cliente.");
                        break;
                    }

                    int i = 1;
                    StringBuilder sb = new StringBuilder();
                    for (Proveedor p: provCl){
                        sb.append(i).append(". ").append(p).append("\n");
                        i++;
                    }
                    System.out.println(sb);

                    System.out.println("Ingrese el indice del proveedor asociado para crear su contrato: ");
                    int idAsociadoContrato = Integer.parseInt(sc.nextLine());

                    Proveedor pr = provCl.get(idAsociadoContrato - 1);

                    System.out.print("Ingrese el costo del contrato: ");
                    String precioEntrada = sc.nextLine();
                    try {
                        precio = Double.parseDouble(precioEntrada);
                    } catch (NumberFormatException e) {
                        precio = -1;
                    }

                    System.out.print("Ingrese el tiempo de duracion del contrato en meses: ");
                    String duracionEntrada = sc.nextLine();
                    try {
                        duracionEnMeses = Integer.parseInt(duracionEntrada);
                    } catch (NumberFormatException e) {
                        duracionEnMeses = -1;
                    }
                    System.out.println("Contrato creado con exito");
                    System.out.println(pr.agregarContrato(precio, duracionEnMeses));

                } break;
                case 5: {
                    System.out.println("===VERIFICAR PROVEEDORES EN UN CLIENTE===");
                    System.out.println(u.listarClientesEmpresa());
                    System.out.print("Ingrese el numero del cliente a verificar: ");
                    int idCl = Integer.parseInt(sc.nextLine());

                    ClienteEmpresa c = u.getIDClienteEmpresa(idCl);
                    if (c == null) break;

                    if (c.getPrContratados().isEmpty()) {
                        System.out.println("Este cliente no tiene proveedores asociados.");
                        break;
                    }

                    System.out.println("Tipos reales del cliente:");
                    for (Proveedor prov : c.getPrContratados()) {
                        System.out.println(prov.getNombre() + " | Tipo:" + prov.tipoProveedor());
                    }

                    System.out.println("Tipo a verificar:");
                    System.out.println("1. Cloud");
                    System.out.println("2. SaaS");
                    System.out.println("3. Pasarelas de pago");
                    System.out.print("Ingrese una opción: ");
                    int opTipo = Integer.parseInt(sc.nextLine());

                    String tipo;

                    switch (opTipo) {
                        case 1:
                            tipo = "Cloud";
                            break;
                        case 2:
                            tipo = "SaaS";
                            break;
                        case 3:
                            tipo = "Pasarelas de pago";
                            break;
                        default:
                            tipo = null;
                            break;
                    }

                    if (tipo == null) {
                        System.out.println("Opción inválida.");
                        break;
                    }

                    boolean tiene = c.verificarTipoProveedor(tipo);

                    System.out.println(tiene
                            ? "El cliente SI posee proveedores de tipo " + tipo
                            : "El cliente NO posee proveedores de tipo " + tipo);

                } break;
                case 6: {
                    System.out.println("===CONTRATOS ACTIVOS DEL SISTEMA===");
                    System.out.println(u.listarContratosActivos());
                } break;
                case 7: {
                    System.out.println("Saliendo del programa...");
                } break;
                default:{
                    System.out.println("Opcion invalida, intentelo nuevamente");
                }
            }
        }while(opc != 7);
    }
}
