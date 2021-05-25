package mk.ukim.finki.bazi.model;

import javax.persistence.*;

@Entity
@Table(name = "magacin", schema = "public", catalog = "magacin")
public class MagacinEntity {
    private int idMagacin;
    private String imeMagacin;
    private String adresaMagacin;

    @Id
    @Column(name = "id_magacin")
    public int getIdMagacin() {
        return idMagacin;
    }

    public void setIdMagacin(int idMagacin) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MagacinEntity that = (MagacinEntity) o;

        if (idMagacin != that.idMagacin) return false;
        if (imeMagacin != null ? !imeMagacin.equals(that.imeMagacin) : that.imeMagacin != null) return false;
        if (adresaMagacin != null ? !adresaMagacin.equals(that.adresaMagacin) : that.adresaMagacin != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMagacin;
        result = 31 * result + (imeMagacin != null ? imeMagacin.hashCode() : 0);
        result = 31 * result + (adresaMagacin != null ? adresaMagacin.hashCode() : 0);
        return result;
    }
}
