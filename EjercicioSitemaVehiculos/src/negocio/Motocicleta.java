package negocio;

import java.util.GregorianCalendar;

public class Motocicleta extends Vehiculo {
    private double altura;
    private String arranque;

    public Motocicleta(String marca, String modelo, int anio, Propietario duenio, double altura, String arranque) {
        super(marca, modelo, anio, duenio);
        this.altura = altura;
        this.arranque = arranque;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getArranque() {
        return arranque;
    }

    public void setArranque(String arranque) {
        this.arranque = arranque;
    }

    @Override
    public String toString(){
        return super.toString() + "\nAltura: " + altura +
                                    "\nArranque: " + arranque + "\n";
    }

    @Override
    public int matricula(){
        GregorianCalendar gc = new GregorianCalendar();
        int anio= gc.get(GregorianCalendar.YEAR);
        int calculo = 200 - (anio-getAnio()*10);
        if (calculo > 0){
            return calculo;
        } return 10;
    }
}
