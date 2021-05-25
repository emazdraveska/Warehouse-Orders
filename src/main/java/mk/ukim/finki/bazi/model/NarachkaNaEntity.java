package mk.ukim.finki.bazi.model;

import javax.persistence.*;

@Entity
@Table(name = "narachka_na", schema = "public", catalog = "magacin")
@IdClass(NarachkaNaEntityPK.class)
public class NarachkaNaEntity {
    private int idNarachka;
    private int idProizvod;
    private int kolichina;

    @Id
    @Column(name = "id_narachka")
    public int getIdNarachka() {
        return idNarachka;
    }

    public void setIdNarachka(int idNarachka) {
        this.idNarachka = idNarachka;
    }

    @Id
    @Column(name = "id_proizvod")
    public int getIdProizvod() {
        return idProizvod;
    }

    public void setIdProizvod(int idProizvod) {
        this.idProizvod = idProizvod;
    }

    @Basic
    @Column(name = "kolichina")
    public int getKolichina() {
        return kolichina;
    }

    public void setKolichina(int kolichina) {
        this.kolichina = kolichina;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NarachkaNaEntity that = (NarachkaNaEntity) o;

        if (idNarachka != that.idNarachka) return false;
        if (idProizvod != that.idProizvod) return false;
        if (kolichina != that.kolichina) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idNarachka;
        result = 31 * result + idProizvod;
        result = 31 * result + kolichina;
        return result;
    }
}
