package negocio;

public class ProveedorPasarelasPago extends Proveedor{
    public ProveedorPasarelasPago(String nombre, String pais) {
        super(nombre, pais);
    }

    @Override
    public String tipoProveedor(){
        return "Pasarelas de Pago";
    }
}
