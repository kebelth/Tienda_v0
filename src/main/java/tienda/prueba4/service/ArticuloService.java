package tienda.prueba4.service;

import java.util.List;
import tienda.prueba4.domain.Articulo;

public interface ArticuloService {

    public List<Articulo> getArticulos(boolean activos);

    public void save(Articulo articulo);

    public void delete(Articulo articulo);

    public Articulo getArticulo(Articulo articulo);

}
