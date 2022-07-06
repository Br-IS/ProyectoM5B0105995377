package me.boris.ProyectoM5B0105995377.service;

import me.boris.ProyectoM5B0105995377.model.Zapatos;

import java.util.List;

public interface ZapatosService {
    Zapatos create(Zapatos zapatos);

    List<Zapatos> read();

    void delete(String codigo);

    Zapatos findById(String codigo);
}
