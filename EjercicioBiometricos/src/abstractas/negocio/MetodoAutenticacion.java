package abstractas.negocio;

public abstract class MetodoAutenticacion {
    private int nivelSeguridad;
    private String tipo;

    public MetodoAutenticacion(int nivelSeguridad, String tipo) {
        this.nivelSeguridad = nivelSeguridad;
        this.tipo = tipo;
    }

    public int getNivelSeguridad() {
        return nivelSeguridad;
    }

    public void setNivelSeguridad(int nivelSeguridad) {
        this.nivelSeguridad = nivelSeguridad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString(){
        return "Tipo: " + tipo +
                "\nNivel de Seguridad: " + nivelSeguridad;
    }

    public abstract boolean autenticar(String dato);
}
