package negocio;

import java.time.Year;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Automovil extends Vehiculo{
    private String traccion;
    private String tipo;

    public Automovil(String marca, String modelo, int anio, Propietario duenio, String traccion, String tipo) {
        super(marca, modelo, anio, duenio);
        this.traccion = traccion;
        this.tipo = tipo;
    }

    public String getTraccion() {
        return traccion;
    }

    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTraccion: " + traccion +
                                    "\nTipo: " + tipo + "\n";

    }

    @Override
    public int matricula(){
        GregorianCalendar gc = new GregorianCalendar();
        int anio= gc.get(GregorianCalendar.YEAR);
        int calculo = 300 - (anio-getAnio()*10);
        if (calculo > 0){
            return calculo;
        } return 10;
    }
}
