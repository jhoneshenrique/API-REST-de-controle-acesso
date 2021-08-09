package com.dio.live.controller;

import com.dio.live.model.CategoriaUsuario;
import com.dio.live.model.Empresa;
import com.dio.live.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @PostMapping
    public Empresa createEmpresa(@RequestBody Empresa empresa){
        return empresaService.saveEmpresa(empresa);
    }

    @GetMapping
    public List<Empresa> getEmpresa(){
        return empresaService.findAll();
    }


    @GetMapping("/{idEmpresa}")
    public ResponseEntity<Empresa> getEmpresaById(@PathVariable("idEmpresa") Long idEmpresa) {
        return ResponseEntity.ok(empresaService.findById(idEmpresa).orElseThrow(()->new NoSuchElementException("Empresa nao encontrada")));
    }

    @PutMapping
    public Empresa updateEmpresa(@RequestBody Empresa empresa){
        return empresaService.updateEmpresa(empresa);
    }


    @DeleteMapping("/{idEmpresa}")
    public ResponseEntity<?> deleteById(@PathVariable("idEmpresa") Long idEmpresa){
        try{
            empresaService.deleteEmpresa(idEmpresa);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return ResponseEntity.ok().build();
    }


}
