package abstractas.negocio;

public class HuellaDigital extends MetodoAutenticacion{
    private String patronHuella;

    public HuellaDigital(int nivelSeguridad, String patronHuella) {
        //No recibe el tipo
        super(nivelSeguridad, "Huella Digital");
        this.patronHuella = patronHuella;
    }

    @Override
    public String toString (){
        return super.toString() + "\nPatron Huella: " + patronHuella;
    }

    @Override
    public boolean autenticar(String dato) {
        if(patronHuella.contains(dato)){
            return true;
        }
        return false;
    }
}
