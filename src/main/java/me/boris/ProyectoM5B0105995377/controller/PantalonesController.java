package me.boris.ProyectoM5B0105995377.controller;

import me.boris.ProyectoM5B0105995377.model.Pantalones;
import me.boris.ProyectoM5B0105995377.service.implement.PantalonesServiceImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pantalones")
public class PantalonesController {

    private Pantalones pantaloncitos;
    private List<Pantalones> pantalonesList, pantalonesList1;

    @Autowired
    private PantalonesServiceImplements pantalonesServiceImplements;

    //READ BY ID
    @GetMapping("/read/{codigo}")
    public ResponseEntity<Pantalones> readById(@PathVariable Integer codigo) {
        pantaloncitos = pantalonesServiceImplements.findById(codigo);
        if (!(pantaloncitos == null)) {
            pantaloncitos = new Pantalones(pantaloncitos.getCodigo(), pantaloncitos.getMarca(), pantaloncitos.getModelo(),
                    pantaloncitos.getFabricante(), pantaloncitos.getCosto(), pantaloncitos.getCantidad(),
                    (pantaloncitos.getCosto() * pantaloncitos.getCantidad()), pantaloncitos.getOrigen());
            return new ResponseEntity<>(pantaloncitos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Pantalones> create(@RequestBody Pantalones pantalones) {
        return new ResponseEntity<>(pantalonesServiceImplements.create(pantalones), HttpStatus.CREATED);
    }

    //READ
    @GetMapping("/read")
    public ResponseEntity<List<Pantalones>> read() {

        pantalonesList = pantalonesServiceImplements.read();
        pantalonesList1 = new ArrayList<>();

        for (int i = 0; i < pantalonesList.size(); i++) {
            pantaloncitos = new Pantalones(pantalonesList.get(i).getCodigo(), pantalonesList.get(i).getMarca(),
                    pantalonesList.get(i).getModelo(), pantalonesList.get(i).getFabricante(), pantalonesList.get(i).getCosto(),
                    pantalonesList.get(i).getCantidad(), (pantalonesList.get(i).getCosto() * pantalonesList.get(i).getCantidad()), pantalonesList.get(i).getOrigen());

            pantalonesList1.add(pantaloncitos);
        }

        return new ResponseEntity<>(pantalonesList1, HttpStatus.OK);

    }

    //UPDATE
    @PutMapping("/update/{codigo}")
    public ResponseEntity<Pantalones> update(@PathVariable Integer codigo, @RequestBody Pantalones pantalones) {
        pantaloncitos = pantalonesServiceImplements.findById(codigo);
        if (!(pantaloncitos == null)) {
            try {
                pantaloncitos.setMarca(pantalones.getMarca());
                pantaloncitos.setModelo(pantalones.getModelo());
                pantaloncitos.setFabricante(pantalones.getFabricante());
                pantaloncitos.setCosto(pantalones.getCosto());
                pantaloncitos.setCantidad(pantalones.getCantidad());
                pantaloncitos.setOrigen(pantalones.getOrigen());

                return new ResponseEntity<>(pantalonesServiceImplements.create(pantaloncitos), HttpStatus.OK);

            } catch (Exception exception) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Pantalones> delete(@PathVariable Integer codigo) {
        pantalonesServiceImplements.delete(codigo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
