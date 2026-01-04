package negocio;

public abstract class Vehiculo{
    private String marca;
    private String modelo;
    private int anio;

    private Propietario duenio;

    public Vehiculo(String marca, String modelo, int anio, Propietario duenio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.duenio = duenio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Propietario getDuenio() {
        return duenio;
    }

    public void setDuenio(Propietario duenio) {
        this.duenio = duenio;
    }

    @Override
    public String toString (){
        return "Marca: " + marca +
                "\nModelo: " + modelo +
                "\nAnio: " + anio +
                "\nPropietario: " + duenio;
    }

    public abstract int matricula();
}
