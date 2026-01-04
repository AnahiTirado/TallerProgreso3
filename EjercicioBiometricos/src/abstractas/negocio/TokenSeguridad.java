package abstractas.negocio;

public class TokenSeguridad extends MetodoAutenticacion{
    private String token;

    public TokenSeguridad(int nivelSeguridad, String token) {
        super(nivelSeguridad, "Token Seguridad");
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString (){
        return super.toString();
    }

    @Override
    public boolean autenticar(String dato) {
        if(token.equals(dato)){
            return true;
        }
        return false;
    }


}
