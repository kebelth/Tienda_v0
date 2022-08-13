
package tienda.prueba4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tienda.prueba4.dao.ClienteDao;
import tienda.prueba4.dao.CreditoDao;
import tienda.prueba4.domain.Cliente;
import tienda.prueba4.domain.Credito;

@Service
public class ClienteServiceImlp implements ClienteService {
    
    
    @Autowired
    private ClienteDao clienteDao;

    
    
    
    @Autowired
    private CreditoDao creditoDao;
    
    
    
    @Override
    @Transactional(readOnly = true)
    public Cliente getByApellidos(Cliente cliente){

         return ((List<Cliente>) clienteDao.findByApellidos (cliente.getApellidos ())).get(0);

    }
    
    
    @Override 
    @Transactional(readOnly = true)
    public List<Cliente> getClientes() {
        
        return (List<Cliente>) clienteDao.findAll();
        
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        Credito credito= cliente.getCredito();
        credito = creditoDao.save(credito);
        cliente.setCredito(credito);
        
        clienteDao.save(cliente);
        
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }
    

    @Override
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
        
    }

   
   
    
}
