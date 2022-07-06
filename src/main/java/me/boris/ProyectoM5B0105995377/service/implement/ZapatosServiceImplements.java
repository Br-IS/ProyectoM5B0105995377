package me.boris.ProyectoM5B0105995377.service.implement;

import me.boris.ProyectoM5B0105995377.model.Zapatos;
import me.boris.ProyectoM5B0105995377.repository.ZapatosRepository;
import me.boris.ProyectoM5B0105995377.service.ZapatosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZapatosServiceImplements implements ZapatosService {

    @Autowired
    private ZapatosRepository zapatosRepository;


    @Override
    public Zapatos create(Zapatos zapatos) {
        return zapatosRepository.save(zapatos);
    }

    @Override
    public List<Zapatos> read() {
        return zapatosRepository.findAll();
    }

    @Override
    public void delete(String codigo) {
        zapatosRepository.deleteById(codigo);   }

    @Override
    public Zapatos findById(String codigo) {
        return zapatosRepository.findById(codigo).orElse(new Zapatos());
    }
}

