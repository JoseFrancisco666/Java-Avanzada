package com.tienda.ecommerce.controller; 

import com.tienda.ecommerce.model.Producto; 
import com.tienda.ecommerce.repository.ProductoRepository; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductoController {

    private final ProductoRepository repository;

    public ProductoController(ProductoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("productos", repository.findAll());
        model.addAttribute("nuevoProducto", new Producto());
        return "index"; 
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Producto producto) {
        repository.save(producto);
        return "redirect:/";
    }
}