package negocio;

import java.util.ArrayList;
import java.util.List;

public abstract class Proveedor {
    private String nombre;
    private String pais;
    private List<Contrato> contratos;

    public Proveedor(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
        contratos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public boolean agregarContrato(double precio, int duracionMeses) {
        if (precio <= 0 || duracionMeses <= 0) return false;
        contratos.add(new Contrato(precio, duracionMeses));
        return true;
    }

    @Override
    public String toString() {
        return  "\nNombre del proveedor: " + nombre +
                "\nPais del proveedor: " + pais;
    }

    public abstract String tipoProveedor();
}
