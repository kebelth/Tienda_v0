
package tienda.prueba4.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tienda.prueba4.domain.Categoria;
import tienda.prueba4.service.CategoriaService;

@Controller
@Slf4j
public class CategoriaController {

    
    
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categoria/listado")
    public String inicio(Model model){
        log.info("Estamos usando una arquitectuta mvc");
        
        var categorias=categoriaService.getCategorias(false);
        model.addAttribute("categorias",categorias);
        return "categoria/listado";
    }
    
    @GetMapping("/categoria/nuevo")
    public String nuevoCategoria(Categoria categoria){
        return "categoria/modificar";
    }
    
    @PostMapping("/categoria/guardar")
    public String guardarCategoria(Categoria categoria){
         categoriaService.save(categoria);
        return "redirect:/categoria/listado";
    }
    
    
    @GetMapping("/categoria/modificar/{idCategoria}")
    public String modificarCategoria(Categoria categoria,Model model){
        categoria = categoriaService.getCategoria(categoria);
        model.addAttribute("categoria", categoria);
        return "categoria/modificar";
    }
    
    @GetMapping("/categoria/eliminar/{idCategoria}")
    public String eliminarCategoria(Categoria categoria,Model model){
        categoriaService.delete(categoria);
       
        return "redirect:/categoria/listado";
    }
    
    
    
}
