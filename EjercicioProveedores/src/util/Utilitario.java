package util;

import negocio.*;

import java.util.ArrayList;
import java.util.List;

public class Utilitario {
    List<Proveedor> proveedores;
    List<ClienteEmpresa> clientes;

    public Utilitario(){
        proveedores = new ArrayList<>();
        clientes = new ArrayList<>();
    }
    public Proveedor crearProveedor(int tipoP, String nombre, String pais){

        Proveedor agregarP = null;

        if (tipoP == 1) {
            agregarP = new ProveedorCloud(nombre, pais);
        } else if (tipoP == 2) {
            agregarP = new ProveedorSaaS(nombre, pais);
        } else {
            agregarP = new ProveedorPasarelasPago(nombre, pais);
        }

        proveedores.add(agregarP);
        System.out.println("Se agregó con exito su proveedor y se registró en el sistema.");
        return agregarP;
    }

    public ClienteEmpresa buscarClienteEmpresa(String nombre){
        for (ClienteEmpresa c: clientes){
            if (c.getNombre().equalsIgnoreCase(nombre)){
                return c;
            }
        } return null;
    }
    public void agregarClienteEmpresa(String nombre){
        ClienteEmpresa cl = buscarClienteEmpresa(nombre);
        if (cl == null){
            clientes.add(new ClienteEmpresa(nombre));
            System.out.println("Cliente agregado con exito");
        } else {
            System.out.println("El cliente empresa ya existe");
        }
    }
    public Proveedor getIDProveedor(int id){
        if(proveedores.isEmpty()){
            System.out.println("No se han registrado proveedores");
        }if(id < 1 || id > proveedores.size()){
            System.out.println("ID no registrado o fuera de rango");
        } return proveedores.get(id - 1);
    }
    public ClienteEmpresa getIDClienteEmpresa(int id){
        if(clientes.isEmpty()){
            System.out.println("No se han registrado proveedores");
        }if(id < 1 || id > clientes.size()){
            System.out.println("ID no registrado o fuera de rango");
        } return clientes.get(id - 1);
    }
    public String listarProveedores(){
        int i = 1;
        StringBuilder sb = new StringBuilder();
        if (proveedores.isEmpty()){
            return "No existen proveedores registrados";
        }
        for (Proveedor p: proveedores){
            sb.append(i).append(". ").append(p).append("\n");
            i++;
        }
        return sb.toString();
    }
    public String listarClientesEmpresa(){
        int i = 1;
        StringBuilder sb = new StringBuilder();
        if (clientes.isEmpty()){
            return "No existen clientes registrados";
        }
        for (ClienteEmpresa c: clientes){
            sb.append(i).append(". ").append(c).append("\n");
            i++;
        }
        return sb.toString();
    }
    public String listarContratosActivos(){
        if(proveedores.isEmpty()){
            System.out.println("No existen proveedores activos");
        }
        int n = 1;
        boolean encontrado = false;
        StringBuilder sb = new StringBuilder();
        for (Proveedor prov: proveedores){
            for (Contrato c: prov.getContratos()){
                if (c.contratoActivo()){
                    encontrado = true;
                    sb.append(n).append(". ").append(prov).append(" | ").append(c).append("\n");
                    n++;
                }
            }
        }
        if (!encontrado){
            return "No existen contratos activos en el sistema";
        }
        return sb.toString();
    }

}
