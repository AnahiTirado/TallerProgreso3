package persona;

public class Profesor extends Persona{
    private String especialidad;

    public Profesor(String cedula, String nombre, String especialidad) {
        super(cedula, nombre);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nEspecialidad: " + especialidad;
    }
}
