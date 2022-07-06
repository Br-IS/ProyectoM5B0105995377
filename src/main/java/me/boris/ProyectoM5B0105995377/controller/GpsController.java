package me.boris.ProyectoM5B0105995377.controller;

import me.boris.ProyectoM5B0105995377.model.Gps;
import me.boris.ProyectoM5B0105995377.service.implement.GpsServiceImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/gps")
public class GpsController {

    private Gps gpsActual;

    @Autowired
    private GpsServiceImplements gpsServiceImplements;

    //READ BY ID
    @GetMapping("/read/{imei}")
    public ResponseEntity<Gps> readByImei(@PathVariable String imei) {
        gpsActual = gpsServiceImplements.findByImei(imei);
        if (!(gpsActual == null)) {
            return new ResponseEntity<>(gpsServiceImplements.findByImei(imei), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //CREATE
    @PostMapping("/create")
    public ResponseEntity<Gps> create(@RequestBody Gps gps) {
        return new ResponseEntity<>(gpsServiceImplements.create(gps), HttpStatus.CREATED);
    }

    //READ
    @GetMapping("/read")
    public ResponseEntity<List<Gps>> read() {
        return new ResponseEntity<>(gpsServiceImplements.read(), HttpStatus.OK);
    }

    //UPDATE
    @PutMapping("/update/{imei}")
    public ResponseEntity<Gps> update(@PathVariable String imei, @RequestBody Gps gps) {
       gpsActual = gpsServiceImplements.findByImei(imei);
        if (!(gpsActual == null)) {
            try{
                gpsActual.setEquipo(gps.getEquipo());
                gpsActual.setNumeroChip(gps.getNumeroChip());
                gpsActual.setSerie(gps.getSerie());
                gpsActual.setCosto(gps.getCosto());
                gpsActual.setObservacion(gps.getObservacion());


                return new ResponseEntity<>(gpsServiceImplements.create(gpsActual), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    //DELETE

    @DeleteMapping("/delete/{imei}")
    public ResponseEntity<Gps> delete(@PathVariable String imei) {
        gpsActual = gpsServiceImplements.findByImei(imei);
        if (!(gpsActual == null)) {
            try {
                gpsServiceImplements.delete(imei);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}




        /*gpsList = gpsServiceImplements.read();
        List<Gps> gpsList1 = new ArrayList<>();

        /*
        for (int i = 0; i < gpsList.size(); i++) {
            gpsActual = new Gps(gpsList.get(i).getImei(), gpsList.get(i).getEquipo(), gpsList.get(i).getNumeroChip(), gpsList.get(i).getSerie(), gpsList.get(i).getCosto(), gpsList.get(i).getObservacion());

            gpsList1.add(gpsActual);
        }*/
