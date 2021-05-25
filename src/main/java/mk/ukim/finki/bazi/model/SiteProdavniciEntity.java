package mk.ukim.finki.bazi.model;

import javax.persistence.*;

@Entity
@Table(name = "site_prodavnici", schema = "public", catalog = "magacin")
public class SiteProdavniciEntity {
    private String id;
    private Integer idProdavnica;
    private String imeProdavnica;
    private String tipProdavnica;
    private String adresaProdavnica;
    private String imeProizvod;
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
    @Column(name = "id_prodavnica")
    public Integer getIdProdavnica() {
        return idProdavnica;
    }

    public void setIdProdavnica(Integer idProdavnica) {
        this.idProdavnica = idProdavnica;
    }

    @Basic
    @Column(name = "ime_prodavnica")
    public String getImeProdavnica() {
        return imeProdavnica;
    }

    public void setImeProdavnica(String imeProdavnica) {
        this.imeProdavnica = imeProdavnica;
    }

    @Basic
    @Column(name = "tip_prodavnica")
    public String getTipProdavnica() {
        return tipProdavnica;
    }

    public void setTipProdavnica(String tipProdavnica) {
        this.tipProdavnica = tipProdavnica;
    }

    @Basic
    @Column(name = "adresa_prodavnica")
    public String getAdresaProdavnica() {
        return adresaProdavnica;
    }

    public void setAdresaProdavnica(String adresaProdavnica) {
        this.adresaProdavnica = adresaProdavnica;
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

        SiteProdavniciEntity that = (SiteProdavniciEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (idProdavnica != null ? !idProdavnica.equals(that.idProdavnica) : that.idProdavnica != null) return false;
        if (imeProdavnica != null ? !imeProdavnica.equals(that.imeProdavnica) : that.imeProdavnica != null)
            return false;
        if (tipProdavnica != null ? !tipProdavnica.equals(that.tipProdavnica) : that.tipProdavnica != null)
            return false;
        if (adresaProdavnica != null ? !adresaProdavnica.equals(that.adresaProdavnica) : that.adresaProdavnica != null)
            return false;
        if (imeProizvod != null ? !imeProizvod.equals(that.imeProizvod) : that.imeProizvod != null) return false;
        if (imeMagacin != null ? !imeMagacin.equals(that.imeMagacin) : that.imeMagacin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (idProdavnica != null ? idProdavnica.hashCode() : 0);
        result = 31 * result + (imeProdavnica != null ? imeProdavnica.hashCode() : 0);
        result = 31 * result + (tipProdavnica != null ? tipProdavnica.hashCode() : 0);
        result = 31 * result + (adresaProdavnica != null ? adresaProdavnica.hashCode() : 0);
        result = 31 * result + (imeProizvod != null ? imeProizvod.hashCode() : 0);
        result = 31 * result + (imeMagacin != null ? imeMagacin.hashCode() : 0);
        return result;
    }
}
