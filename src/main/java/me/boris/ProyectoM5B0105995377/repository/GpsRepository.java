package me.boris.ProyectoM5B0105995377.repository;

import me.boris.ProyectoM5B0105995377.model.Gps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GpsRepository extends JpaRepository<Gps,Integer> {

    Gps findByImei(String imei);
    void deleteByImei(String imei);
}
