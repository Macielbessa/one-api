package com.procutapi.food.repository;


import com.procutapi.food.model.ProductModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<ProductModel, Integer> {
    //Listar todos os produtos
    List<ProductModel> findAll();

    // Pesquisar por códigos
    ProductModel findByCode(int code);

    //Remover produto
    void delete(ProductModel product);

    //Cadastrar ou alterar produto
        <ProMod extends ProductModel> ProMod save(ProMod entity);
}
