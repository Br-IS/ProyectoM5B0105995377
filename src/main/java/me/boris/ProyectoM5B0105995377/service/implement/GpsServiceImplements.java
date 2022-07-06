package me.boris.ProyectoM5B0105995377.service.implement;

import me.boris.ProyectoM5B0105995377.model.Gps;
import me.boris.ProyectoM5B0105995377.repository.GpsRepository;
import me.boris.ProyectoM5B0105995377.service.GpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GpsServiceImplements implements GpsService{

    @Autowired
    private GpsRepository gpsRepository;

    @Override
    public Gps create(Gps gps) {
        return gpsRepository.save(gps);
    }

    @Override
    public List<Gps> read() {
        return gpsRepository.findAll();
    }

    @Override
    public void delete(String codigo) {
        gpsRepository.deleteByImei(codigo);
    }

    @Override
    public Gps findByImei(String codigo) {
        return gpsRepository.findByImei(codigo);
    }

}
