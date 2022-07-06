/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.boris.ProyectoM5B0105995377.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Boris
 */
@Entity
@Table(name = "gps")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gps.findAll", query = "SELECT g FROM Gps g")
    , @NamedQuery(name = "Gps.findById", query = "SELECT g FROM Gps g WHERE g.id = :id")
    , @NamedQuery(name = "Gps.findByImei", query = "SELECT g FROM Gps g WHERE g.imei = :imei")
    , @NamedQuery(name = "Gps.findByEquipo", query = "SELECT g FROM Gps g WHERE g.equipo = :equipo")
    , @NamedQuery(name = "Gps.findByNumeroChip", query = "SELECT g FROM Gps g WHERE g.numeroChip = :numeroChip")
    , @NamedQuery(name = "Gps.findBySerie", query = "SELECT g FROM Gps g WHERE g.serie = :serie")
    , @NamedQuery(name = "Gps.findByCosto", query = "SELECT g FROM Gps g WHERE g.costo = :costo")
    , @NamedQuery(name = "Gps.findByObservacion", query = "SELECT g FROM Gps g WHERE g.observacion = :observacion")})
public class Gps implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "imei")
    private String imei;
    @Size(max = 45)
    @Column(name = "equipo")
    private String equipo;
    @Size(max = 45)
    @Column(name = "numero_chip")
    private String numeroChip;
    @Size(max = 45)
    @Column(name = "serie")
    private String serie;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costo")
    private Double costo;
    @Size(max = 1024)
    @Column(name = "observacion")
    private String observacion;

    public Gps() {
    }

    public Gps(Integer id, String imei, String equipo, String numeroChip, String serie, Double costo, String observacion) {
        this.id = id;
        this.imei = imei;
        this.equipo = equipo;
        this.numeroChip = numeroChip;
        this.serie = serie;
        this.costo = costo;
        this.observacion = observacion;
    }

    public Gps(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getNumeroChip() {
        return numeroChip;
    }

    public void setNumeroChip(String numeroChip) {
        this.numeroChip = numeroChip;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gps)) {
            return false;
        }
        Gps other = (Gps) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "me.boris.ProyectoM5B0105995377.model.Gps[ id=" + id + " ]";
    }
    
}
