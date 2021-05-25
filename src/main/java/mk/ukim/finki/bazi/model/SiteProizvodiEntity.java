package mk.ukim.finki.bazi.model;

import javax.persistence.*;

@Entity
@Table(name = "site_proizvodi", schema = "public", catalog = "magacin")
public class SiteProizvodiEntity {
    private String id;
    private Integer idProizvod;
    private String imeProizvod;
    private String tipProizvod;
    private Integer kolichina;
    private Integer vrednost;
    private String imeMagacin;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_proizvod")
    public Integer getIdProizvod() {
        return idProizvod;
    }

    public void setIdProizvod(Integer idProizvod) {
        this.idProizvod = idProizvod;
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
    @Column(name = "tip_proizvod")
    public String getTipProizvod() {
        return tipProizvod;
    }

    public void setTipProizvod(String tipProizvod) {
        this.tipProizvod = tipProizvod;
    }

    @Basic
    @Column(name = "kolichina")
    public Integer getKolichina() {
        return kolichina;
    }

    public void setKolichina(Integer kolichina) {
        this.kolichina = kolichina;
    }

    @Basic
    @Column(name = "vrednost")
    public Integer getVrednost() {
        return vrednost;
    }

    public void setVrednost(Integer vrednost) {
        this.vrednost = vrednost;
    }

    @Basic
    @Column(name = "ime_magacin")
    public String getImeMagacin() {
        return imeMagacin;
    }

    public void setImeMagacin(String imeMagacin) {
        this.imeMagacin = imeMagacin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SiteProizvodiEntity that = (SiteProizvodiEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (idProizvod != null ? !idProizvod.equals(that.idProizvod) : that.idProizvod != null) return false;
        if (imeProizvod != null ? !imeProizvod.equals(that.imeProizvod) : that.imeProizvod != null) return false;
        if (tipProizvod != null ? !tipProizvod.equals(that.tipProizvod) : that.tipProizvod != null) return false;
        if (kolichina != null ? !kolichina.equals(that.kolichina) : that.kolichina != null) return false;
        if (vrednost != null ? !vrednost.equals(that.vrednost) : that.vrednost != null) return false;
        if (imeMagacin != null ? !imeMagacin.equals(that.imeMagacin) : that.imeMagacin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (idProizvod != null ? idProizvod.hashCode() : 0);
        result = 31 * result + (imeProizvod != null ? imeProizvod.hashCode() : 0);
        result = 31 * result + (tipProizvod != null ? tipProizvod.hashCode() : 0);
        result = 31 * result + (kolichina != null ? kolichina.hashCode() : 0);
        result = 31 * result + (vrednost != null ? vrednost.hashCode() : 0);
        result = 31 * result + (imeMagacin != null ? imeMagacin.hashCode() : 0);
        return result;
    }
}
