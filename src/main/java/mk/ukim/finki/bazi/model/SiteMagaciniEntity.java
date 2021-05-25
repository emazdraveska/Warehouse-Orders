package mk.ukim.finki.bazi.model;

import javax.persistence.*;

@Entity
@Table(name = "site_magacini", schema = "public", catalog = "magacin")
public class SiteMagaciniEntity {
    private String id;
    private Integer idMagacin;
    private String imeMagacin;
    private String adresaMagacin;
    private String imeProizvod;
    private Integer kolichina;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_magacin")
    public Integer getIdMagacin() {
        return idMagacin;
    }

    public void setIdMagacin(Integer idMagacin) {
        this.idMagacin = idMagacin;
    }

    @Basic
    @Column(name = "ime_magacin")
    public String getImeMagacin() {
        return imeMagacin;
    }

    public void setImeMagacin(String imeMagacin) {
        this.imeMagacin = imeMagacin;
    }

    @Basic
    @Column(name = "adresa_magacin")
    public String getAdresaMagacin() {
        return adresaMagacin;
    }

    public void setAdresaMagacin(String adresaMagacin) {
        this.adresaMagacin = adresaMagacin;
    }

    @Basic
    @Column(name = "ime_proizvod")
    public String getImeProizvod() {
        return imeProizvod;
    }

    public void setImeProizvod(String imeProizvod) {
        this.imeProizvod = imeProizvod;
    }

    @Basic
    @Column(name = "kolichina")
    public Integer getKolichina() {
        return kolichina;
    }

    public void setKolichina(Integer kolichina) {
        this.kolichina = kolichina;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SiteMagaciniEntity that = (SiteMagaciniEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (idMagacin != null ? !idMagacin.equals(that.idMagacin) : that.idMagacin != null) return false;
        if (imeMagacin != null ? !imeMagacin.equals(that.imeMagacin) : that.imeMagacin != null) return false;
        if (adresaMagacin != null ? !adresaMagacin.equals(that.adresaMagacin) : that.adresaMagacin != null)
            return false;
        if (imeProizvod != null ? !imeProizvod.equals(that.imeProizvod) : that.imeProizvod != null) return false;
        if (kolichina != null ? !kolichina.equals(that.kolichina) : that.kolichina != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (idMagacin != null ? idMagacin.hashCode() : 0);
        result = 31 * result + (imeMagacin != null ? imeMagacin.hashCode() : 0);
        result = 31 * result + (adresaMagacin != null ? adresaMagacin.hashCode() : 0);
        result = 31 * result + (imeProizvod != null ? imeProizvod.hashCode() : 0);
        result = 31 * result + (kolichina != null ? kolichina.hashCode() : 0);
        return result;
    }
}
