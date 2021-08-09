package com.dio.live.controller;

import com.dio.live.model.CategoriaUsuario;
import com.dio.live.model.Localidade;
import com.dio.live.service.LocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/localidade")
public class LocalidadeController {

    @Autowired
    LocalidadeService localidadeService;

    @PostMapping
    public Localidade createLocalidade(@RequestBody Localidade localidade){
        return localidadeService.saveLocalidade(localidade);
    }

    @GetMapping
    public List<Localidade> getLocalidade(){
        return localidadeService.findAll();
    }


    @GetMapping("/{idLocalidade}")
    public ResponseEntity<Localidade> getLocalidadeById(@PathVariable("idLocalidade") Long idLocalidade) {
        return ResponseEntity.ok(localidadeService.findById(idLocalidade).orElseThrow(()->new NoSuchElementException("Localidade nao encontrada")));
    }

    @PutMapping
    public Localidade updateLocalidade(@RequestBody Localidade localidade){
        return localidadeService.updateLocalidade(localidade);
    }


    @DeleteMapping("/{idLocalidade}")
    public ResponseEntity<?> deleteById(@PathVariable("idLocalidade") Long idLocalidade){
        try{
            localidadeService.deleteLocalidade(idLocalidade);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return ResponseEntity.ok().build();
    }
}
