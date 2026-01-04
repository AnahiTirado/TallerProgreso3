package abstractas.negocio;

public class ReconocimientoFacial extends MetodoAutenticacion{
    private String patronRostro;

    public ReconocimientoFacial(int nivelSeguridad, String patronRostro) {
        super(nivelSeguridad, "Reconocimiento Facial");
        this.patronRostro = patronRostro;
    }

    public String getPatronRostro() {
        return patronRostro;
    }

    public void setPatronRostro(String patronRostro) {
        this.patronRostro = patronRostro;
    }

    @Override
    public String toString (){
        return super.toString() + "\nPatron Rostro: " + patronRostro;
    }

    @Override
    public boolean autenticar(String dato) {
        if(patronRostro.contains(dato)){
            return true;
        }
        return false;
    }

}
