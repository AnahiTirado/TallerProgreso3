package util;

import negocio.Automovil;
import negocio.Motocicleta;
import negocio.Propietario;
import negocio.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class Utilitario {
    private List<Propietario> propietarios;
    private List<Vehiculo> vehiculos;

    public Utilitario() {
        propietarios = new ArrayList<>();
        vehiculos = new ArrayList<>();
    }

    public void agregarPropietario(String cedula, String nombre, String telefono) {
        if (cedula == null || cedula.isBlank()) {
            throw new IllegalArgumentException("La cédula no puede ser vacía");
        }

        if (burscarPropietario(cedula) != null) {
            throw new IllegalStateException("El propietario ya existe");
        }

        propietarios.add(new Propietario(cedula, nombre, telefono));
    }

    public void agregarAuto(String marca, String modelo, int anio,
                            Propietario duenio, String traccion, String tipo) {

        if (duenio == null) {
            throw new IllegalArgumentException("El propietario no puede ser null");
        }

        vehiculos.add(new Automovil(marca, modelo, anio, duenio, traccion, tipo));
    }

    public void agregarMoto(String marca, String modelo, int anio,
                            Propietario duenio, double altura, String arranque) {

        if (duenio == null) {
            throw new IllegalArgumentException("El propietario no puede ser null");
        }

        vehiculos.add(new Motocicleta(marca, modelo, anio, duenio, altura, arranque));
    }

    public Propietario burscarPropietario(String cedula) {
        for (Propietario p : propietarios) {
            if (p.getCedula().equals(cedula)) {
                return p;
            }
        }
        return null;
    }

    public List<Vehiculo> buscarVehiculoMarca(String marca) {
        if (vehiculos.isEmpty()) {
            throw new IllegalStateException("No existen vehículos registrados");
        }

        List<Vehiculo> busqueda = new ArrayList<>();
        for (Vehiculo v : vehiculos) {
            if (v.getMarca().equalsIgnoreCase(marca)) {
                busqueda.add(v);
            }
        }

        if (busqueda.isEmpty()) {
            throw new IllegalStateException("No existen vehículos de la marca: " + marca);
        }

        return busqueda;
    }

    public String listarVehiculos() {
        if (vehiculos.isEmpty()) {
            throw new IllegalStateException("No existen vehículos registrados");
        }

        StringBuilder sb = new StringBuilder();
        for (Vehiculo v : vehiculos) {
            sb.append(v).append("\n");
        }
        return sb.toString();
    }

    public String listarNombreAnioArranqueMotoMarca(String marca) {
        if (vehiculos.isEmpty()) {
            throw new IllegalStateException("No existen vehículos registrados");
        }

        StringBuilder sb = new StringBuilder();
        boolean encontrado = false;

        for (Vehiculo v : vehiculos) {
            if (v.getMarca().equalsIgnoreCase(marca) && v instanceof Motocicleta) {
                Motocicleta m = (Motocicleta) v;
                sb.append("Nombre: ").append(m.getDuenio().getNombre()).append("\n");
                sb.append("Año: ").append(m.getAnio()).append("\n");
                sb.append("Arranque: ").append(m.getArranque()).append("\n\n");
                encontrado = true;
            }
        }

        if (!encontrado) {
            throw new IllegalStateException("No existen motocicletas de la marca: " + marca);
        }

        return sb.toString();
    }

    public String listarAutomoviles() {
        if (vehiculos.isEmpty()) {
            throw new IllegalStateException("No existen vehículos registrados");
        }

        StringBuilder sb = new StringBuilder();
        boolean encontrado = false;

        for (Vehiculo v : vehiculos) {
            if (v instanceof Automovil) {
                sb.append(v).append("\n");
                encontrado = true;
            }
        }

        if (!encontrado) {
            throw new IllegalStateException("No existen automóviles registrados");
        }

        return sb.toString();
    }

    public String listaPropietarios() {
        if (propietarios.isEmpty()) {
            throw new IllegalStateException("No existen propietarios registrados");
        }

        StringBuilder sb = new StringBuilder();
        for (Propietario p : propietarios) {
            sb.append(p).append("\n");
        }
        return sb.toString();
    }

    public int matricula(String cedula, String marca, int anio) {
        for (Vehiculo v : vehiculos) {
            if (v.getMarca().equalsIgnoreCase(marca)
                    && v.getDuenio().getCedula().equals(cedula)
                    && v.getAnio() == anio) {
                return v.matricula();
            }
        }
        throw new IllegalStateException("Vehículo no encontrado para matriculación");
    }

    public void menu() {
        System.out.println("Bienvenido/a al sistema de vehículos");
        System.out.println("1. Agregar propietario");
        System.out.println("2. Asignar propietario a auto");
        System.out.println("3. Asignar propietario a moto");
        System.out.println("4. Buscar Vehículos por marca");
        System.out.println("5. Listar Vehículos");
        System.out.println("6. Listar Propietarios");
        System.out.println("7. Listar Automóviles");
        System.out.println("8. Listar Moto según marca");
        System.out.println("9. Matricular");
        System.out.println("10. Salir");
        System.out.print("Ingrese una opción para continuar: ");
    }
}

