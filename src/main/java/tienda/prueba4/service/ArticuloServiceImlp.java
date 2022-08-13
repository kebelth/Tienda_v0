
package tienda.prueba4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tienda.prueba4.dao.ArticuloDao;
import tienda.prueba4.domain.Articulo;

@Service
public class ArticuloServiceImlp implements ArticuloService {
    
    
    @Autowired
    private ArticuloDao articuloDao;

    @Override 
    @Transactional(readOnly = true)
    public List<Articulo> getArticulos(boolean activos) {
        var lista =(List<Articulo>) articuloDao.findAll();
        if(activos){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
        
    }

    @Override
    @Transactional
    public void save(Articulo articulo) {
        articuloDao.save(articulo);
        
    }

    @Override
    @Transactional
    public void delete(Articulo articulo) {
        articuloDao.delete(articulo);
    }
    

    @Override
    public Articulo getArticulo(Articulo articulo) {
        return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
        
    }
    
}
