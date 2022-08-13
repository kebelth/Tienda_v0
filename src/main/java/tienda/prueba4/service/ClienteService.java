package tienda.prueba4.service;

import java.util.List;
import tienda.prueba4.domain.Cliente;

public interface ClienteService {


    public Cliente getByApellidos(Cliente cliente);

    public List<Cliente> getClientes();

    public void save(Cliente cliente);

    public void delete(Cliente cliente);

    public Cliente getCliente(Cliente cliente);

}
