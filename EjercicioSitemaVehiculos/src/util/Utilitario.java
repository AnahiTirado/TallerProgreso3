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

    //No tiene constructor por parametros
    public Utilitario (){
        propietarios = new ArrayList<>();
        vehiculos = new ArrayList<>();
    }

    public void agregarPropietario(String cedula, String nombre, String telefono){
        Propietario pr = burscarPropietario(cedula);
        if(pr==null){
            propietarios.add(new Propietario(cedula, nombre, telefono));
        }
        else {
            System.out.println("El propietario ya existe");
        }
    }
    public void agregarAuto(String marca, String modelo, int anio, Propietario duenio, String traccion, String tipo){
        vehiculos.add(new Automovil(marca, modelo, anio, duenio, traccion, tipo));
    }
    public void agregarMoto(String marca, String modelo, int anio, Propietario duenio, double altura, String arranque){
        vehiculos.add(new Motocicleta(marca, modelo, anio, duenio, altura, arranque));
    }

    public Propietario burscarPropietario (String cedula){
        for (Propietario p: propietarios) {
            if (p.getCedula().equals(cedula)){
                return p;
            }
        }
        return null;
    }
    public List<Vehiculo> buscarVehiculoMarca(String marca){
        List<Vehiculo> busqueda = new ArrayList<>();
        for (Vehiculo v: vehiculos){
            if(v.getMarca().equalsIgnoreCase(marca)){
                busqueda.add(v);
            }
        } return busqueda;
    }

    public String listarVehiculos(){
        String aux = "";
        for(int i=0; i<vehiculos.size(); i++){
            aux += vehiculos.get(i);
            aux += "\n";

        }return aux;
    }
    public String listarNombreAnioArranqueMotoMarca(String marca){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<vehiculos.size(); i++){
            if(vehiculos.get(i).getMarca().equalsIgnoreCase(marca)){
                if(vehiculos.get(i) instanceof Motocicleta) {
                    Motocicleta m = (Motocicleta) vehiculos.get(i);
                    sb.append("Nombre: " + m.getDuenio().getNombre() + "\n");
                    sb.append("Anio: " + m.getAnio() + "\n");
                    sb.append("Arranque: " + m.getArranque() + "\n");
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }

    public String listarAutomoviles (){
        StringBuilder sb = new StringBuilder();
        for(Vehiculo v: vehiculos){
            if(v instanceof Automovil){
                Automovil a = (Automovil) v;
                sb.append(a);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public String listaPropietarios(){
        StringBuilder sb =new StringBuilder();

        for(int i=0; i<propietarios.size(); i++){
            sb.append(propietarios.get(i).toString());
            sb.append("\n");
        }return sb.toString();
    }
    public int matricula(String cedula, String marca, int anio){
        for (Vehiculo v : vehiculos){
            if(v.getMarca().equalsIgnoreCase(marca)&& v.getDuenio().getCedula().equals(cedula) && v.getAnio() == anio){
                return v.matricula();
            }
        }return -1;
    }

    public void menu(){
        System.out.println("Bienvenido/a al sistema de vehiculos");
        System.out.println("1. Agregar propietario");
        System.out.println("2. Asignar propietario a auto");
        System.out.println("3. Asignar propietario a moto");
        System.out.println("4. Buscar Vehiculos por marca");
        System.out.println("5. Listar Vehiculos");
        System.out.println("6. Listar Propietarios");
        System.out.println("7. Listar Automoviles");
        System.out.println("8. Listar Moto segun marca");
        System.out.println("9. Matricular");
        System.out.println("10. Salir");
        System.out.println("Ingrese una opcion para continuar: ");
    }


}
