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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Boris
 */
@Entity
@Table(name = "zapatos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zapatos.findAll", query = "SELECT z FROM Zapatos z")
    , @NamedQuery(name = "Zapatos.findByCodigo", query = "SELECT z FROM Zapatos z WHERE z.codigo = :codigo")
    , @NamedQuery(name = "Zapatos.findByMarca", query = "SELECT z FROM Zapatos z WHERE z.marca = :marca")
    , @NamedQuery(name = "Zapatos.findByCosto", query = "SELECT z FROM Zapatos z WHERE z.costo = :costo")
    , @NamedQuery(name = "Zapatos.findByCantidad", query = "SELECT z FROM Zapatos z WHERE z.cantidad = :cantidad")
    , @NamedQuery(name = "Zapatos.findByCostoTotal", query = "SELECT z FROM Zapatos z WHERE z.costoTotal = :costoTotal")
    , @NamedQuery(name = "Zapatos.findByTipoZapato", query = "SELECT z FROM Zapatos z WHERE z.tipoZapato = :tipoZapato")})
public class Zapatos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "codigo")
    private String codigo;
    @Size(max = 45)
    @Column(name = "marca")
    private String marca;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costo")
    private Double costo;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "costo_total")
    private Double costoTotal;
    @Size(max = 45)
    @Column(name = "tipo_zapato")
    private String tipoZapato;

    public Zapatos() {
    }

    public Zapatos(String codigo, String marca, Double costo, Integer cantidad, Double costoTotal, String tipoZapato) {
        this.codigo = codigo;
        this.marca = marca;
        this.costo = costo;
        this.cantidad = cantidad;
        this.costoTotal = costoTotal;
        this.tipoZapato = tipoZapato;
    }

    public Zapatos(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

   public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String getTipoZapato() {
        return tipoZapato;
    }

    public void setTipoZapato(String tipoZapato) {
        this.tipoZapato = tipoZapato;
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
        if (!(object instanceof Zapatos)) {
            return false;
        }
        Zapatos other = (Zapatos) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "me.boris.ProyectoM5B0105995377.model.Zapatos[ codigo=" + codigo + " ]";
    }
    
}
