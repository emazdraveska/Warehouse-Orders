package mk.ukim.finki.bazi.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "site_narachki", schema = "public", catalog = "magacin")
public class SiteNarachkiEntity {
    private String id;
    private Integer idNarachka;
    private String imeProdavnica;
    private String imeProizvod;
    private Integer kolichina;
    private Integer vkupnaCena;
    private Timestamp datumNarachka;
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
    @Column(name = "id_narachka")
    public Integer getIdNarachka() {
        return idNarachka;
    }

    public void setIdNarachka(Integer idNarachka) {
        this.idNarachka = idNarachka;
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

    @Basic
    @Column(name = "vkupna_cena")
    public Integer getVkupnaCena() {
        return vkupnaCena;
    }

    public void setVkupnaCena(Integer vkupnaCena) {
        this.vkupnaCena = vkupnaCena;
    }

    @Basic
    @Column(name = "datum_narachka")
    public Timestamp getDatumNarachka() {
        return datumNarachka;
    }

    public void setDatumNarachka(Timestamp datumNarachka) {
        this.datumNarachka = datumNarachka;
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

        SiteNarachkiEntity that = (SiteNarachkiEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (idNarachka != null ? !idNarachka.equals(that.idNarachka) : that.idNarachka != null) return false;
        if (imeProdavnica != null ? !imeProdavnica.equals(that.imeProdavnica) : that.imeProdavnica != null)
            return false;
        if (imeProizvod != null ? !imeProizvod.equals(that.imeProizvod) : that.imeProizvod != null) return false;
        if (kolichina != null ? !kolichina.equals(that.kolichina) : that.kolichina != null) return false;
        if (vkupnaCena != null ? !vkupnaCena.equals(that.vkupnaCena) : that.vkupnaCena != null) return false;
        if (datumNarachka != null ? !datumNarachka.equals(that.datumNarachka) : that.datumNarachka != null)
            return false;
        if (imeMagacin != null ? !imeMagacin.equals(that.imeMagacin) : that.imeMagacin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (idNarachka != null ? idNarachka.hashCode() : 0);
        result = 31 * result + (imeProdavnica != null ? imeProdavnica.hashCode() : 0);
        result = 31 * result + (imeProizvod != null ? imeProizvod.hashCode() : 0);
        result = 31 * result + (kolichina != null ? kolichina.hashCode() : 0);
        result = 31 * result + (vkupnaCena != null ? vkupnaCena.hashCode() : 0);
        result = 31 * result + (datumNarachka != null ? datumNarachka.hashCode() : 0);
        result = 31 * result + (imeMagacin != null ? imeMagacin.hashCode() : 0);
        return result;
    }

    public String string(){
        return imeProdavnica + " od: " + imeMagacin;

    }
    @Override
    public String toString() {
        return imeProizvod + ", Kolichina: " + kolichina + " cena: " +vkupnaCena ;
    }

}
