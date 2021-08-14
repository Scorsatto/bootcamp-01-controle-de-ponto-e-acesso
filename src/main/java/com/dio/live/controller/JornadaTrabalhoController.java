package com.dio.live.controller;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.JornadaTrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

    @Autowired
    JornadaTrabalhoService jornadaTrabalhoService;

    @PostMapping
    public JornadaTrabalho createJornadaTrabalho(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaTrabalhoService.save(jornadaTrabalho);
    }

    @GetMapping
    public List<JornadaTrabalho> getJornadaTrabalhoList(){
        return jornadaTrabalhoService.findAll();
    }

    @GetMapping("/{idJornada}")
    public ResponseEntity<JornadaTrabalho> getJornadaByID(@PathVariable("idJornada") Long idJornada) throws Exception {
        return  ResponseEntity.ok(jornadaTrabalhoService.getById(idJornada).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public JornadaTrabalho updateJornadaTrabalho(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaTrabalhoService.update(jornadaTrabalho);
    }

    @DeleteMapping("/{idJornada}")
    public ResponseEntity deleteById(@PathVariable("idJornada") Long idJornada) throws Exception {
        try {
            jornadaTrabalhoService.deleteById(idJornada);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<JornadaTrabalho>) ResponseEntity.ok();
    }
}
