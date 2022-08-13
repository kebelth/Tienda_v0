
package tienda.prueba4.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import tienda.prueba4.domain.Cliente;


public interface ClienteDao extends CrudRepository<Cliente,Long> {
    
    public List<Cliente> findByApellidos(String apellidos);
    
   



}
