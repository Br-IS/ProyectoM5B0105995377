package me.boris.ProyectoM5B0105995377.service.implement;

import me.boris.ProyectoM5B0105995377.model.Casas;
import me.boris.ProyectoM5B0105995377.repository.CasasRepository;
import me.boris.ProyectoM5B0105995377.service.CasasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CasasServiceImplements implements CasasService {

    @Autowired
    private CasasRepository casasRepository;

    @Override
    public Casas create(Casas casas) {
        return casasRepository.save(casas);
    }

    @Override
    public List<Casas> read() {
        return casasRepository.findAll();
    }

    @Override
    public void delete(String codigo) {
        casasRepository.deleteById(codigo);
    }

    @Override
    public Casas findById(String codigo) {
        return casasRepository.findById(codigo).orElse(new Casas());
    }
}
