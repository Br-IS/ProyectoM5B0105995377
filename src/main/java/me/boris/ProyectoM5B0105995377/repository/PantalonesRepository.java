package me.boris.ProyectoM5B0105995377.repository;

import me.boris.ProyectoM5B0105995377.model.Pantalones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PantalonesRepository extends JpaRepository<Pantalones, Integer> {
}
