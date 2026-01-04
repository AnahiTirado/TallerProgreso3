package negocio;

public class ProveedorSaaS extends Proveedor{
    public ProveedorSaaS(String nombre, String pais){
        super(nombre, pais);
    }

    @Override
    public String tipoProveedor(){
        return "SaaS";
    }
}
