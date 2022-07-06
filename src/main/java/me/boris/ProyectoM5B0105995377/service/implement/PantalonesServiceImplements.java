package me.boris.ProyectoM5B0105995377.service.implement;

import me.boris.ProyectoM5B0105995377.model.Pantalones;
import me.boris.ProyectoM5B0105995377.repository.PantalonesRepository;
import me.boris.ProyectoM5B0105995377.service.PantalonesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PantalonesServiceImplements implements PantalonesService
{
    @Autowired
    private PantalonesRepository pantalonesRepository;

    @Override
    public Pantalones create(Pantalones pantalones) {
        return pantalonesRepository.save(pantalones);
    }

    @Override
    public List<Pantalones> read() {
        return pantalonesRepository.findAll();
    }

    @Override
    public void delete(Integer codigo) {
pantalonesRepository.deleteById(codigo);
    }

    @Override
    public Pantalones findById(Integer codigo) {
        return pantalonesRepository.findById(codigo).orElse(new Pantalones());
    }
}

