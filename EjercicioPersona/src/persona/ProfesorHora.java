package persona;

public class ProfesorHora extends Profesor{
    private int horas;

    public ProfesorHora(String cedula, String nombre, String especialidad, int horas) {
        super(cedula, nombre, especialidad);
        this.horas = horas;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nHoras: " + horas;
    }
}
