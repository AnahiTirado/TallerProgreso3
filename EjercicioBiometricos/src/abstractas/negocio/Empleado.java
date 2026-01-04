package abstractas.negocio;

import java.util.ArrayList;
import java.util.List;

public class Empleado {
    private String cedula;
    private String nombre;
    private List<MetodoAutenticacion> autenticaciones;

    public Empleado(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
        autenticaciones = new ArrayList<>();
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public List<MetodoAutenticacion> getAutenticaciones() {
        return autenticaciones;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void adicionarAuth(MetodoAutenticacion m){  //Recibe el parametro de la clase abstracta
        autenticaciones.add(m);
    }

    public int cantidadRegistroHuella(){
        int cont = 0;
        for (MetodoAutenticacion m: autenticaciones){
            if(m instanceof HuellaDigital){
                cont++;
            }
        }
        return cont;
    }
    public int cantidadRegistroRostro(){
        int cont = 0;
        for (MetodoAutenticacion m: autenticaciones){
            if(m instanceof ReconocimientoFacial){
                cont++;
            }
        }
        return cont;
    }
    public int cantidadRegistroToken(){
        int cont = 0;
        for (MetodoAutenticacion m: autenticaciones){
            if(m instanceof TokenSeguridad){
                cont++;
            }
        }
        return cont;
    }

    public boolean autenticar(String dato, String tipo){
        for (MetodoAutenticacion m: autenticaciones){
            if (m.getTipo().equalsIgnoreCase(tipo)){
                if(m.autenticar(dato)){
                    return true;
                }
            }
        }
        return false;
    }

    public String seguridadMayorUmbral(int valor){
        String seguridad = "";
        for (MetodoAutenticacion m: autenticaciones){
            if (m.getNivelSeguridad() >= valor){
                seguridad += m.getTipo();
                seguridad += "\n";
            }
        }
        return seguridad;
    }

    @Override
    public String toString(){
        return "\nCedula: " + cedula +
                "\nNombre: " + nombre +
                "\nMetodos de Autencicacion: " + autenticaciones;
    }

}
