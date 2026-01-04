package persona;

public class AlumnoPregrado extends Alumno{
    private String carrera;

    public AlumnoPregrado(String cedula, String nombre, String universidad, String carrera) {
        super(cedula, nombre, universidad);
        this.carrera = carrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nCarrera: " + carrera;
    }

}
