package mk.ukim.finki.bazi.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class SeNaogjaVoEntityPK implements Serializable {
    private int idProizvod;
    private int idMagacin;

    @Column(name = "id_proizvod")
    @Id
    public int getIdProizvod() {
        return idProizvod;
    }

    public void setIdProizvod(int idProizvod) {
        this.idProizvod = idProizvod;
    }

    @Column(name = "id_magacin")
    @Id
    public int getIdMagacin() {
        return idMagacin;
    }

    public void setIdMagacin(int idMagacin) {
        this.idMagacin = idMagacin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SeNaogjaVoEntityPK that = (SeNaogjaVoEntityPK) o;

        if (idProizvod != that.idProizvod) return false;
        if (idMagacin != that.idMagacin) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProizvod;
        result = 31 * result + idMagacin;
        return result;
    }
}
