package me.boris.ProyectoM5B0105995377.controller;

import me.boris.ProyectoM5B0105995377.model.Zapatos;
import me.boris.ProyectoM5B0105995377.service.implement.ZapatosServiceImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/zapatos")
public class ZapatosController {

    private Zapatos zapatito;
    private List<Zapatos> zapatosList;
    @Autowired
    private ZapatosServiceImplements zapatosServiceImplements;

    //READ BY ID
    @GetMapping("/read/{codigo}")
    public ResponseEntity<Zapatos> readById(@PathVariable String codigo) {
        zapatito = zapatosServiceImplements.findById(codigo);
        if (!(zapatito == null)){
            zapatito.setCostoTotal(zapatito.getCosto() * zapatito.getCantidad());

           // zapatito = new Zapatos(zapatito.getCodigo(),zapatito.getMarca(),zapatito.getCosto(),zapatito.getCantidad(),zapatito.getCosto() * zapatito.getCantidad(),zapatito.getTipoZapato());
            return new ResponseEntity<>(zapatito, HttpStatus.OK);

        }else{
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //CREATE
    @PostMapping("/create")
    public ResponseEntity<Zapatos> create(@RequestBody Zapatos zapatos) {
        zapatosList = zapatosServiceImplements.read();

        zapatos.setCodigo(String.format("za_%03d", (zapatosList.size() + 1)));
        zapatos.setCostoTotal(0.00);

        zapatito = new Zapatos(zapatos.getCodigo(), zapatos.getMarca(), zapatos.getCosto(), zapatos.getCantidad(), zapatos.getCostoTotal(), zapatos.getTipoZapato());

        return new ResponseEntity<>(zapatosServiceImplements.create(zapatito), HttpStatus.CREATED);

    }

    //READ
    @GetMapping("/read")
    public ResponseEntity<List<Zapatos>> read() {
        return new ResponseEntity<>(zapadosMetodo(zapatosServiceImplements.read()), HttpStatus.OK);
    }

    private List<Zapatos> zapadosMetodo(List<Zapatos> zapatosList){
        List<Zapatos> zapatosList2 = new ArrayList<>();
        Zapatos zapatitos;
        for (int i = 0; i < zapatosList.size(); i++) {
            zapatitos = new Zapatos (zapatosList.get(i).getCodigo(), zapatosList.get(i).getMarca(),
                    zapatosList.get(i).getCosto(), zapatosList.get(i).getCantidad(), (zapatosList.get(i).getCosto() * zapatosList.get(i).getCantidad()), zapatosList.get(i).getTipoZapato());
            zapatosList2.add(zapatitos);
        }
        return zapatosList2;
    }

    //UPDATE
    @PutMapping("/update/{codigo}")
    public ResponseEntity<Zapatos> update(@PathVariable String codigo, @RequestBody Zapatos zapatos) {
        zapatito = zapatosServiceImplements.findById(codigo);
        if (!(zapatito == null)) {
            try {
                zapatito.setMarca(zapatos.getMarca());
                zapatito.setCosto(zapatos.getCosto());
                zapatito.setCantidad(zapatos.getCantidad());
                zapatito.setTipoZapato(zapatos.getTipoZapato());

                return new ResponseEntity<>(zapatosServiceImplements.create(zapatito), HttpStatus.OK);

            } catch (Exception exception) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Zapatos> delete(@PathVariable String codigo) {
        zapatosServiceImplements.delete(codigo);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}