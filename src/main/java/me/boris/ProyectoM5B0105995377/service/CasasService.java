package me.boris.ProyectoM5B0105995377.service;

import me.boris.ProyectoM5B0105995377.model.Casas;

import java.util.List;

public interface CasasService {

     Casas create(Casas casas);

     List<Casas> read();

     void delete(String codigo);

     Casas findById(String codigo);
}
