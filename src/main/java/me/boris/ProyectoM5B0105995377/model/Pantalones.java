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
@Table(name = "pantalones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pantalones.findAll", query = "SELECT p FROM Pantalones p")
    , @NamedQuery(name = "Pantalones.findByCodigo", query = "SELECT p FROM Pantalones p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Pantalones.findByMarca", query = "SELECT p FROM Pantalones p WHERE p.marca = :marca")
    , @NamedQuery(name = "Pantalones.findByModelo", query = "SELECT p FROM Pantalones p WHERE p.modelo = :modelo")
    , @NamedQuery(name = "Pantalones.findByFabricante", query = "SELECT p FROM Pantalones p WHERE p.fabricante = :fabricante")
    , @NamedQuery(name = "Pantalones.findByCosto", query = "SELECT p FROM Pantalones p WHERE p.costo = :costo")
    , @NamedQuery(name = "Pantalones.findByCantidad", query = "SELECT p FROM Pantalones p WHERE p.cantidad = :cantidad")
    , @NamedQuery(name = "Pantalones.findByCostoTotal", query = "SELECT p FROM Pantalones p WHERE p.costoTotal = :costoTotal")
    , @NamedQuery(name = "Pantalones.findByOrigen", query = "SELECT p FROM Pantalones p WHERE p.origen = :origen")})
public class Pantalones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Size(max = 45)
    @Column(name = "marca")
    private String marca;
    @Size(max = 45)
    @Column(name = "modelo")
    private String modelo;
    @Size(max = 45)
    @Column(name = "fabricante")
    private String fabricante;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costo")
    private Double costo;
    @Column(name = "cantidad")
    private Double cantidad;
    @Column(name = "costo_total")
    private Double costoTotal;
    @Size(max = 45)
    @Column(name = "origen")
    private String origen;

    public Pantalones() {
    }

    public Pantalones(Integer codigo, String marca, String modelo, String fabricante, Double costo, Double cantidad, Double costoTotal, String origen) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.costo = costo;
        this.cantidad = cantidad;
        this.costoTotal = costoTotal;
        this.origen = origen;
    }

    public Pantalones(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pantalones)) {
            return false;
        }
        Pantalones other = (Pantalones) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "me.boris.ProyectoM5B0105995377.model.Pantalones[ codigo=" + codigo + " ]";
    }
    
}
