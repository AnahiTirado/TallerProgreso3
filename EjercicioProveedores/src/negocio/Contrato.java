package negocio;

public class Contrato {
    private double precio;
    private int duracionEnMeses;

    public Contrato(double precio, int duracionEnMeses) {
        this.precio = precio;
        this.duracionEnMeses = duracionEnMeses;
    }

    public double getPrecio() {
        return precio;
    }

    public int getDuracionEnMeses() {
        return duracionEnMeses;
    }
    public boolean contratoActivo(){
        boolean activo = true;
        if (precio > 0 && duracionEnMeses > 0) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public String toString(){
        return "Costo: " + precio + " | Duracion: " + duracionEnMeses;
    }

}
