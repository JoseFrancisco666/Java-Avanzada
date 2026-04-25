package com.calculadora.app.controller;

import com.calculadora.app.model.Operacion;
import com.calculadora.app.repository.OperacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CalculadoraController {

    @Autowired // Inyección de dependencia (Requisito de la tarea)
    private OperacionRepository repository;

    @GetMapping("/calcular")
    public String calcular(
            @RequestParam double a, 
            @RequestParam double b, 
            @RequestParam String op) {
        
        double res = 0;
        String nombreOp = "";

        // Lógica de la calculadora
        switch (op.toLowerCase()) {
            case "suma": res = a + b; nombreOp = "Suma"; break;
            case "resta": res = a - b; nombreOp = "Resta"; break;
            case "multi": res = a * b; nombreOp = "Multiplicación"; break;
            case "div": 
                if (b == 0) return "Error: No se puede dividir entre cero";
                res = a / b; nombreOp = "División"; break;
            default: return "Operación no válida. Usa: suma, resta, multi o div";
        }

        // Crear el objeto Modelo y llenarlo
        Operacion entidad = new Operacion();
        entidad.setNum1(a);
        entidad.setNum2(b);
        entidad.setTipo(nombreOp);
        entidad.setResultado(res);

        // Misión: Guardar en la base de datos a través del Repositorio
        repository.save(entidad);

        return nombreOp + " realizada: " + a + " y " + b + " = " + res + " (Guardado en Base de Datos)";
    }

    @GetMapping("/historial")
    public List<Operacion> verTodo() {
        // Misión: Buscar todos los registros guardados
        return repository.findAll();
    }
}