package negocio;


public class Propietario {
    private String cedula;
    private String nombre;
    private String telefono;

    public Propietario(String cedula, String nombre, String telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getCedula() {
        return cedula; //Set no, la cedula no cambia
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "\nCedula:  " + cedula +
                "\nNombre: " + nombre +
                "\nTelefono: " + telefono;
    }
}
