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
@Table(name = "casas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Casas.findAll", query = "SELECT c FROM Casas c")
    , @NamedQuery(name = "Casas.findByCodigo", query = "SELECT c FROM Casas c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Casas.findByPropietario", query = "SELECT c FROM Casas c WHERE c.propietario = :propietario")
    , @NamedQuery(name = "Casas.findByArea", query = "SELECT c FROM Casas c WHERE c.area = :area")
    , @NamedQuery(name = "Casas.findByCostoTotal", query = "SELECT c FROM Casas c WHERE c.costoTotal = :costoTotal")
    , @NamedQuery(name = "Casas.findByTipoTerreno", query = "SELECT c FROM Casas c WHERE c.tipoTerreno = :tipoTerreno")})
public class Casas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "codigo")
    private String codigo;
    @Size(max = 45)
    @Column(name = "propietario")
    private String propietario;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "area")
    private Double area;
    @Column(name = "costo_total")
    private Double costoTotal;
    @Size(max = 45)
    @Column(name = "tipo_terreno")
    private String tipoTerreno;

    public Casas() {
    }

    public Casas(String codigo) {
        this.codigo = codigo;
    }

    public Casas(String codigo, String propietario, Double area, Double costoTotal, String tipoTerreno) {
        this.codigo = codigo;
        this.propietario = propietario;
        this.area = area;
        this.costoTotal = costoTotal;
        this.tipoTerreno = tipoTerreno;
    }

    public String getCodigo() {
        return codigo;
    }


    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String getTipoTerreno() {
        return tipoTerreno;
    }

    public void setTipoTerreno(String tipoTerreno) {
        this.tipoTerreno = tipoTerreno;
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
        if (!(object instanceof Casas)) {
            return false;
        }
        Casas other = (Casas) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "me.boris.ProyectoM5B0105995377.model.Casas[ codigo=" + codigo + " ]";
    }
    
}
