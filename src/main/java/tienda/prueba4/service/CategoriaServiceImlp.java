
package tienda.prueba4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tienda.prueba4.dao.CategoriaDao;
import tienda.prueba4.domain.Categoria;

@Service
public class CategoriaServiceImlp implements CategoriaService {
    
    
    @Autowired
    private CategoriaDao categoriaDao;

    @Override 
    @Transactional(readOnly = true)
    public List<Categoria> getCategorias(boolean activos) {
        var lista =(List<Categoria>) categoriaDao.findAll();
        if(activos){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
        
    }

    @Override
    @Transactional
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
        
    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }
    

    @Override
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
        
    }
    
}
