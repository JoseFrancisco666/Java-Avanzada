package com.calculadora.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Operacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double num1;
    private double num2;
    private String tipo;
    private double resultado;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getNum1() { return num1; }
    public void setNum1(double num1) { this.num1 = num1; }

    public double getNum2() { return num2; }
    public void setNum2(double num2) { this.num2 = num2; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public double getResultado() { return resultado; }
    public void setResultado(double resultado) { this.resultado = resultado; }
}