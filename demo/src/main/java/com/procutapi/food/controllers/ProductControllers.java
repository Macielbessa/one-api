package com.procutapi.food.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;


import com.procutapi.food.repository.ProductRepository;
import com.procutapi.food.model.AnswerModel;
import com.procutapi.food.model.ProductModel;



@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost")
public class ProductControllers {
    //métodos sendo feitos
    @Autowired
        private ProductRepository actions;

    //Listar produtos
        @RequestMapping(value="/product", method = RequestMethod.GET)

        public @ResponseBody
        List<ProductModel> list(){
            return actions.findAll();
        }
    //cadastrar produtos
// criando o método
    @RequestMapping(value ="/product", method=RequestMethod.POST)
    public @ResponseBody ProductModel register(@RequestBody ProductModel product) {
        return actions.save(product);
    }

    //Filtrar produtos
    @RequestMapping(value="/produtos{codigo}", method = RequestMethod.GET)
    public @ResponseBody ProductModel filter(@PathVariable Integer code){
        return actions.findByCode(code);
    }

    //Alterar produtos
    @RequestMapping(value="/product", method = RequestMethod.PUT)
    public @ResponseBody ProductModel change(@RequestBody ProductModel product) {
        return actions.save(product);
    }

    //Remover produtos
    @RequestMapping(value="/product/{code}", method = RequestMethod.DELETE)
    public @ResponseBody AnswerModel toremove(@PathVariable Integer code) {
        //criando uma instancia
        AnswerModel answer = new AnswerModel();
        try {
            ProductModel product = filter(code);
            this.actions.delete(product);
            answer.setMessage("Produto removido com sucesso");
        } catch(Exception erro) {
            answer.setMessage("Falha ao remover" + erro.getMessage());
        }
        return answer;
    }
}
