package com.dio.live.controller;

import com.dio.live.model.CategoriaUsuario;
import com.dio.live.model.NivelAcesso;
import com.dio.live.service.CategoriaUsuarioService;
import com.dio.live.service.NivelAcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/nivelacesso")
public class NivelAcessoController {

    @Autowired
    NivelAcessoService nivelAcessoService;

    @PostMapping
    public NivelAcesso createNivelAcesso(@RequestBody NivelAcesso nivelAcesso){
        return nivelAcessoService.saveNivelAcesso(nivelAcesso);
    }

    @GetMapping
    public List<NivelAcesso> getNivelAcesso(){
        return nivelAcessoService.findAll();
    }


    @GetMapping("/{idNivelAcesso}")
    public ResponseEntity<NivelAcesso> getNivelAcessoById(@PathVariable("idNivelAcesso") Long idNivelAcesso) {
        return ResponseEntity.ok(nivelAcessoService.findById(idNivelAcesso).orElseThrow(()->new NoSuchElementException("Nivel acesso nao encontrado")));
    }

    @PutMapping
    public NivelAcesso updateNivelAcesso(@RequestBody NivelAcesso nivelAcesso){
        return nivelAcessoService.updateNivelAcesso(nivelAcesso);
    }


    @DeleteMapping("/{idNivelAcesso}")
    public ResponseEntity<?> deleteById(@PathVariable("idNivelAcesso") Long idNivelAcesso){
        try{
            nivelAcessoService.deleteNivelAcesso(idNivelAcesso);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return ResponseEntity.ok().build();
    }


}
