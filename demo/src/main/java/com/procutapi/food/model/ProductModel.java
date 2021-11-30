package com.procutapi.food.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity // UMA ANOTAÇÃO QUE IRÁ ESTABELECER A LIGAÇÃO ENTRE A ENTIDADE E A TABELA NO BANCO DE DADOS
@Table(name="product")

public class ProductModel {

    //3 atribuitos e criações de colunas
// implementando os ID

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="code")
    private int code;


    @Column(name="name")
    private String name;

    @Column(name="value")
    private double value;

    //GET E SETTERS
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }
}
