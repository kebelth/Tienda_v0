package tienda.prueba4.service;

import java.util.List;
import tienda.prueba4.domain.Categoria;

public interface CategoriaService {

    public List<Categoria> getCategorias(boolean activos);

    public void save(Categoria categoria);

    public void delete(Categoria categoria);

    public Categoria getCategoria(Categoria categoria);

}
