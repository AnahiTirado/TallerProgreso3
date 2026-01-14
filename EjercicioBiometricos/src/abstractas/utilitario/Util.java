package abstractas.utilitario;

import abstractas.negocio.Empleado;
import abstractas.negocio.HuellaDigital;
import abstractas.negocio.ReconocimientoFacial;
import abstractas.negocio.TokenSeguridad;
import abstractas.negocio.*;

import java.util.ArrayList;
import java.util.List;

public class Util {
    private List<Empleado> empleados;

    public Util() {
        empleados = new ArrayList<>();
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void agregarEmpleados(String cedula, String nombre) {
        int indice = buscarEmpleado(cedula);
        if (indice == -1) {
            empleados.add(new Empleado(cedula, nombre));
        } else {
            throw new IllegalStateException("Empleado ya existe con cédula: " + cedula);
        }
    }

    public int buscarEmpleado(String cedula) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getCedula().equals(cedula)) {
                return i;
            }
        }
        return -1;
    }

    public void agregarMetodoAuthHuella(String cedula, int nivelSeguridad, String patronHuella) {
        int indice = buscarEmpleado(cedula);
        if (indice == -1) {
            throw new IllegalArgumentException("Empleado NO existe: " + cedula);
        }
        empleados.get(indice).adicionarAuth(new HuellaDigital(nivelSeguridad, patronHuella));
    }

    public void agregarMetodoAuthFacial(String cedula, int nivelSeguridad, String patronRostro) {
        int indice = buscarEmpleado(cedula);
        if (indice == -1) {
            throw new IllegalArgumentException("Empleado NO existe: " + cedula);
        }

        if (empleados.get(indice).cantidadRegistroRostro() > 0) {
            throw new IllegalStateException("Solo se permite un registro facial por empleado");
        }

        empleados.get(indice).adicionarAuth(new ReconocimientoFacial(nivelSeguridad, patronRostro));
    }

    public void agregarMetodoAuthToken(String cedula, int nivelSeguridad, String token) {
        int indice = buscarEmpleado(cedula);
        if (indice == -1) {
            throw new IllegalArgumentException("Empleado NO existe: " + cedula);
        }
        empleados.get(indice).adicionarAuth(new TokenSeguridad(nivelSeguridad, token));
    }

    public int cantidadAuthHuella(String cedula) {
        int indice = buscarEmpleado(cedula);
        if (indice == -1) {
            throw new IllegalArgumentException("Empleado NO existe: " + cedula);
        }
        return empleados.get(indice).cantidadRegistroHuella();
    }

    public int cantidadAuthRostro(String cedula) {
        int indice = buscarEmpleado(cedula);
        if (indice == -1) {
            throw new IllegalArgumentException("Empleado NO existe: " + cedula);
        }
        return empleados.get(indice).cantidadRegistroRostro();
    }

    public int cantidadAuthToken(String cedula) {
        int indice = buscarEmpleado(cedula);
        if (indice == -1) {
            throw new IllegalArgumentException("Empleado NO existe: " + cedula);
        }
        return empleados.get(indice).cantidadRegistroToken();
    }

    public String authMayorSeguridad(String cedula, int nivelSeguridad) {
        int indice = buscarEmpleado(cedula);
        if (indice == -1) {
            throw new IllegalArgumentException("Empleado NO existe: " + cedula);
        }
        return empleados.get(indice).seguridadMayorUmbral(nivelSeguridad);
    }

    public boolean autenticar(String dato, String tipo, String cedula) {
        int indice = buscarEmpleado(cedula);
        if (indice == -1) {
            throw new IllegalArgumentException("Empleado NO existe: " + cedula);
        }
        return empleados.get(indice).autenticar(dato, tipo);
    }

    public String autenticarStr(String tipo, String dato, String cedula) {
        int indice = buscarEmpleado(cedula);
        if (indice == -1) {
            throw new IllegalArgumentException("Empleado NO existe: " + cedula);
        }

        return empleados.get(indice).autenticar(dato, tipo)
                ? "Autenticación Permitida"
                : "Autenticación Denegada";
    }

    public String cantidadAuthTotal(String cedula) {
        int indice = buscarEmpleado(cedula);
        if (indice == -1) {
            throw new IllegalArgumentException("Empleado NO existe: " + cedula);
        }

        Empleado e = empleados.get(indice);
        if (e.getAutenticaciones().isEmpty()) {
            return "Empleado encontrado - Sin métodos de autenticación registrados";
        }

        StringBuilder sb = new StringBuilder();
        for (MetodoAutenticacion m : e.getAutenticaciones()) {
            sb.append(m).append("\n");
        }
        return sb.toString();
    }

    public void menu() {
        System.out.println("\n==== MENU ====");
        System.out.println("1. Agregar - Empleado");
        System.out.println("2. Agregar - Token de Seguridad");
        System.out.println("3. Agregar - Reconocimiento Facial");
        System.out.println("4. Agregar - Huella Digital");
        System.out.println("5. Mostrar - Datos de Empleados (Todos)");
        System.out.println("6. Buscar - Empleado y Mostrar Datos");
        System.out.println("7. Mostrar - Total Métodos de Autenticación por Empleado");
        System.out.println("8. Mostrar - Total Métodos Huella por Empleado");
        System.out.println("9. Mostrar - Total Métodos Token por Empleado");
        System.out.println("10. Mostrar - Total Métodos Facial por Empleado");
        System.out.println("11. Mostrar - Métodos Mayor a Umbral por Empleado");
        System.out.println("12. Autenticar - Empleado");
        System.out.println("13. Salir");
        System.out.print("Ingrese una opción: ");
    }
}
