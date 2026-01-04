package negocio;

import java.util.ArrayList;
import java.util.List;

public class ClienteEmpresa {
    private String nombre;
    private List<Proveedor> prContratados;

    public ClienteEmpresa(String nombre) {
        this.nombre = nombre;
        prContratados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Proveedor> getPrContratados() {
        return prContratados;
    }

    public boolean contratarProveedor(Proveedor proveedor) {
        if (proveedor == null) return false;

        for (Proveedor p : prContratados) {
            if (p.getNombre().equalsIgnoreCase(proveedor.getNombre())) {
                return false; // ya contratado
            }
        }
        prContratados.add(proveedor);
        System.out.println("Proveedor contratado");
        return true;
    }

    public boolean verificarTipoProveedor(String tipo) {
        if (tipo == null) return false;

        String buscado = tipo.trim();

        for (Proveedor p : prContratados) {
            String t = p.tipoProveedor();
            if (t != null && t.trim().equalsIgnoreCase(buscado)) {
                return true;
            }
        } return false;
    }

    public List<Contrato> contratosActivos(){
        List<Contrato> activos = new ArrayList<>();
        for (Proveedor p : prContratados) {
            for (Contrato c : p.getContratos()) {
                if (c.contratoActivo()) {
                    activos.add(c);
                }
            }
        }
        return activos;
    }


    @Override
    public String toString(){
        return "Nombre de la empresa: " + nombre;
    }

}
