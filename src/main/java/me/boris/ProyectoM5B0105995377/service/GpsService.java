package me.boris.ProyectoM5B0105995377.service;

import me.boris.ProyectoM5B0105995377.model.Gps;

import java.util.List;

public interface GpsService {
    Gps create(Gps gps);

    List<Gps> read();

    void delete(String imei);

    Gps findByImei(String imei);
}
