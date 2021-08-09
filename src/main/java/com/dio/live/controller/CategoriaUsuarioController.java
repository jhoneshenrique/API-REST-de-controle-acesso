package com.dio.live.controller;

import com.dio.live.model.CategoriaUsuario;
import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.CategoriaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/categoriausuario")
public class CategoriaUsuarioController {

    @Autowired
    CategoriaUsuarioService cateoriaUsuarioService;

    @PostMapping
    public CategoriaUsuario createCategoriaUsuario(@RequestBody CategoriaUsuario categoriaUsuario){
        return cateoriaUsuarioService.saveCategoriaUsuario(categoriaUsuario);
    }

    @GetMapping
    public List<CategoriaUsuario> getCategoriaUsuario(){
        return cateoriaUsuarioService.findAll();
    }


    @GetMapping("/{idCategoriaUsuario}")
    public ResponseEntity<CategoriaUsuario> getCategoriaUsuarioById(@PathVariable("idCategoriaUsuario") Long idCategoriaUsuario) {
        return ResponseEntity.ok(cateoriaUsuarioService.findById(idCategoriaUsuario).orElseThrow(()->new NoSuchElementException("Categoria nao encontrada")));
    }

    @PutMapping
    public CategoriaUsuario updateCategoriaUsuario(@RequestBody CategoriaUsuario categoriaUsuario){
        return cateoriaUsuarioService.updateCategoria(categoriaUsuario);
    }


    @DeleteMapping("/{idCategoriaUsuario}")
    public ResponseEntity<?> deleteById(@PathVariable("idCategoriaUsuario") Long idCategoriaUsuario){
        try{
            cateoriaUsuarioService.deleteCategoriaUsuario(idCategoriaUsuario);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return ResponseEntity.ok().build();
    }



}
