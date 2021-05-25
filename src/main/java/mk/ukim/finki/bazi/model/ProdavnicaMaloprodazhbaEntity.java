package mk.ukim.finki.bazi.model;

import javax.persistence.*;

@Entity
@Table(name = "prodavnica_maloprodazhba", schema = "public", catalog = "magacin")
public class ProdavnicaMaloprodazhbaEntity {
    private int idProdavnica;
    private String imeProdavnica;
    private String tipProdavnica;
    private String adresaProdavnica;

    @Id
    @Column(name = "id_prodavnica")
    public int getIdProdavnica() {
        return idProdavnica;
    }

    public void setIdProdavnica(int idProdavnica) {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProdavnicaMaloprodazhbaEntity that = (ProdavnicaMaloprodazhbaEntity) o;

        if (idProdavnica != that.idProdavnica) return false;
        if (imeProdavnica != null ? !imeProdavnica.equals(that.imeProdavnica) : that.imeProdavnica != null)
            return false;
        if (tipProdavnica != null ? !tipProdavnica.equals(that.tipProdavnica) : that.tipProdavnica != null)
            return false;
        if (adresaProdavnica != null ? !adresaProdavnica.equals(that.adresaProdavnica) : that.adresaProdavnica != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProdavnica;
        result = 31 * result + (imeProdavnica != null ? imeProdavnica.hashCode() : 0);
        result = 31 * result + (tipProdavnica != null ? tipProdavnica.hashCode() : 0);
        result = 31 * result + (adresaProdavnica != null ? adresaProdavnica.hashCode() : 0);
         return result;
    }
}
