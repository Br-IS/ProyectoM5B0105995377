package me.boris.ProyectoM5B0105995377.service;

import me.boris.ProyectoM5B0105995377.model.Pantalones;

import java.util.List;

public interface PantalonesService {

    Pantalones create(Pantalones pantalones);

    List<Pantalones> read();

    void delete(Integer codigo);

    Pantalones findById(Integer codigo);
}
