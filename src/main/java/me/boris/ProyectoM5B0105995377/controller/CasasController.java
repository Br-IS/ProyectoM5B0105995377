package me.boris.ProyectoM5B0105995377.controller;

import me.boris.ProyectoM5B0105995377.model.Casas;
import me.boris.ProyectoM5B0105995377.service.implement.CasasServiceImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/casas")
public class CasasController {

    private Casas casita;
    private List<Casas> casasList, casasList1;
    private double valorTerreno = 80.00;


    @Autowired
    private CasasServiceImplements casasServiceImplements;

    //READY BY ID
    @GetMapping("/read/{codigo}")
    public ResponseEntity<Casas> readById(@PathVariable String codigo) {
        casita = casasServiceImplements.findById(codigo);
        if (!(casita == null)) {
            casita = new Casas(casita.getCodigo(), casita.getPropietario(), casita.getArea(), casita.getArea()*valorTerreno , casita.getTipoTerreno() );

            return new ResponseEntity<>(casita, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //CREATE
    @PostMapping("/create")
    public ResponseEntity<Casas> create(@RequestBody Casas casas) {
        casasList = casasServiceImplements.read();

        casas.setCodigo(String.format("CA_%03d", casasList.size() + 1));

        casas.setCostoTotal(0.00);

        casita = new Casas(casas.getCodigo(), casas.getPropietario(), casas.getArea(), casas.getCostoTotal(), casas.getTipoTerreno());

        return new ResponseEntity<>(casasServiceImplements.create(casita), HttpStatus.CREATED);
    }

    //READ
    @GetMapping("/read")
    public ResponseEntity<List<Casas>> read() {
        casasList = casasServiceImplements.read();

        casasList1 = new ArrayList<>();
        for (int i = 0; i < casasList.size(); i++) {
            casasList.get(i).setCostoTotal(casasList.get(i).getArea() * valorTerreno);
            casita = new Casas(casasList.get(i).getCodigo(), casasList.get(i).getPropietario(), casasList.get(i).getArea(),
                    casasList.get(i).getCostoTotal(), casasList.get(i).getTipoTerreno());

            casasList1.add(casita);
        }
        return new ResponseEntity<>(casasList1, HttpStatus.OK);
    }

    //UPDATE
    @PutMapping("/update/{codigo}")
    public ResponseEntity<Casas> update(@PathVariable String codigo, @RequestBody Casas casas) {
        casita = casasServiceImplements.findById(codigo);

        if (!(casita == null)) {
            try {
                casita.setPropietario(casas.getPropietario());
                casita.setArea(casas.getArea());
                casita.setTipoTerreno(casas.getTipoTerreno());
                return new ResponseEntity<>(casasServiceImplements.create(casita), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    //DELETE
    @DeleteMapping("/delete/{codigo}")
    public ResponseEntity<Casas> delete(@PathVariable String codigo) {
        casita = casasServiceImplements.findById(codigo);

        if (!(casita == null)) {
            casasServiceImplements.delete(codigo);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}