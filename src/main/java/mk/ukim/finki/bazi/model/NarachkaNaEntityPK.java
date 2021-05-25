package mk.ukim.finki.bazi.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class NarachkaNaEntityPK implements Serializable {
    private int idNarachka;
    private int idProizvod;

    @Column(name = "id_narachka")
    @Id
    public int getIdNarachka() {
        return idNarachka;
    }

    public void setIdNarachka(int idNarachka) {
        this.idNarachka = idNarachka;
    }

    @Column(name = "id_proizvod")
    @Id
    public int getIdProizvod() {
        return idProizvod;
    }

    public void setIdProizvod(int idProizvod) {
        this.idProizvod = idProizvod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NarachkaNaEntityPK that = (NarachkaNaEntityPK) o;

        if (idNarachka != that.idNarachka) return false;
        if (idProizvod != that.idProizvod) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idNarachka;
        result = 31 * result + idProizvod;
        return result;
    }
}
