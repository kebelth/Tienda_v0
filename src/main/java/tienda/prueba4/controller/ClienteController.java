package tienda.prueba4.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tienda.prueba4.domain.Cliente;
import tienda.prueba4.service.ClienteService;

@Controller
@Slf4j
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cliente/busqueda")
    public String busqueda(Cliente cliente) {
        return "cliente/buscar";
    }

    @PostMapping("/cliente/buscar")
    public String buscarCliente(Cliente cliente, Model model) {
        cliente = clienteService.getByApellidos(cliente);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "/cliente/modificar";
        } else {

            return "/cliente/buscar";
        }

    }

    @GetMapping("/cliente/listado")
    public String inicio(Model model) {
        log.info("Estamos usando una arquitectuta mvc");

        var clientes = clienteService.getClientes();
        var limiteTotal = 0;
        for (var c : clientes) {
            limiteTotal += c.getCredito().getLimite();
        }
   model.addAttribute("limiteTotal",limiteTotal);
   model.addAttribute("totalClientes",clientes.size());
    model.addAttribute ("clientes",clientes);

return "cliente/listado";
    }
    
    @GetMapping("/cliente/nuevo")
public String nuevoCliente(Cliente cliente){
        return "cliente/modificar";
    }
    
    @PostMapping("/cliente/guardar")
public String guardarCliente(Cliente cliente){
         clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }
    
    
    @GetMapping("/cliente/modificar/{idCliente}")
public String modificarCliente(Cliente cliente,Model model){
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "cliente/modificar";
    }
    
    @GetMapping("/cliente/eliminar/{idCliente}")
public String eliminarCliente(Cliente cliente,Model model){
        clienteService.delete(cliente);
       
        return "redirect:/cliente/listado";
    }
    
    
    
}
