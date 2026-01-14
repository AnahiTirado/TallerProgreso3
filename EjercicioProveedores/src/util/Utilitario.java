package util;

import negocio.*;

import java.util.ArrayList;
import java.util.List;

public class Utilitario {
    List<Proveedor> proveedores;
    List<ClienteEmpresa> clientes;

    public Utilitario() {
        proveedores = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    public Proveedor crearProveedor(int tipoP, String nombre, String pais) {

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del proveedor no puede ser vacío");
        }
        if (pais == null || pais.isBlank()) {
            throw new IllegalArgumentException("El país del proveedor no puede ser vacío");
        }

        Proveedor agregarP;

        if (tipoP == 1) {
            agregarP = new ProveedorCloud(nombre, pais);
        } else if (tipoP == 2) {
            agregarP = new ProveedorSaaS(nombre, pais);
        } else if (tipoP == 3) {
            agregarP = new ProveedorPasarelasPago(nombre, pais);
        } else {
            throw new IllegalArgumentException("Tipo de proveedor inválido");
        }

        proveedores.add(agregarP);
        return agregarP;
    }

    public ClienteEmpresa buscarClienteEmpresa(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del cliente no puede ser vacío");
        }

        for (ClienteEmpresa c : clientes) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }

    public void agregarClienteEmpresa(String nombre) {
        if (buscarClienteEmpresa(nombre) != null) {
            throw new IllegalStateException("El cliente empresa ya existe: " + nombre);
        }
        clientes.add(new ClienteEmpresa(nombre));
    }

    public Proveedor getIDProveedor(int id) {
        if (proveedores.isEmpty()) {
            throw new IllegalStateException("No se han registrado proveedores");
        }
        if (id < 1 || id > proveedores.size()) {
            throw new IllegalArgumentException("ID de proveedor fuera de rango");
        }
        return proveedores.get(id - 1);
    }

    public ClienteEmpresa getIDClienteEmpresa(int id) {
        if (clientes.isEmpty()) {
            throw new IllegalStateException("No se han registrado clientes empresa");
        }
        if (id < 1 || id > clientes.size()) {
            throw new IllegalArgumentException("ID de cliente empresa fuera de rango");
        }
        return clientes.get(id - 1);
    }

    public String listarProveedores() {
        if (proveedores.isEmpty()) {
            throw new IllegalStateException("No existen proveedores registrados");
        }

        int i = 1;
        StringBuilder sb = new StringBuilder();
        for (Proveedor p : proveedores) {
            sb.append(i++).append(". ").append(p).append("\n");
        }
        return sb.toString();
    }

    public String listarClientesEmpresa() {
        if (clientes.isEmpty()) {
            throw new IllegalStateException("No existen clientes registrados");
        }

        int i = 1;
        StringBuilder sb = new StringBuilder();
        for (ClienteEmpresa c : clientes) {
            sb.append(i++).append(". ").append(c).append("\n");
        }
        return sb.toString();
    }

    public String listarContratosActivos() {
        if (proveedores.isEmpty()) {
            throw new IllegalStateException("No existen proveedores registrados");
        }

        int n = 1;
        boolean encontrado = false;
        StringBuilder sb = new StringBuilder();

        for (Proveedor prov : proveedores) {
            for (Contrato c : prov.getContratos()) {
                if (c.contratoActivo()) {
                    encontrado = true;
                    sb.append(n++)
                            .append(". ")
                            .append(prov)
                            .append(" | ")
                            .append(c)
                            .append("\n");
                }
            }
        }

        if (!encontrado) {
            throw new IllegalStateException("No existen contratos activos en el sistema");
        }

        return sb.toString();
    }
}

