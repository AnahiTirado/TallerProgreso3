package persona;

public class Alumno extends Persona{
    private String universidad;

    public Alumno(String cedula, String nombre, String universidad) {
        super(cedula, nombre);
        this.universidad = universidad;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nUniversidad: " + universidad ;
    }
}
