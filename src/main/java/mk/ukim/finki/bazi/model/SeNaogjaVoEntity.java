package mk.ukim.finki.bazi.model;

import javax.persistence.*;

@Entity
@Table(name = "se_naogja_vo", schema = "public", catalog = "magacin")
@IdClass(SeNaogjaVoEntityPK.class)
public class SeNaogjaVoEntity {
    private int idProizvod;
    private int idMagacin;
    private int kolichina;

    @Id
    @Column(name = "id_proizvod")
    public int getIdProizvod() {
        return idProizvod;
    }

    public void setIdProizvod(int idProizvod) {
        this.idProizvod = idProizvod;
    }

    @Id
    @Column(name = "id_magacin")
    public int getIdMagacin() {
        return idMagacin;
    }

    public void setIdMagacin(int idMagacin) {
        this.idMagacin = idMagacin;
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

        SeNaogjaVoEntity that = (SeNaogjaVoEntity) o;

        if (idProizvod != that.idProizvod) return false;
        if (idMagacin != that.idMagacin) return false;
        if (kolichina != that.kolichina) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProizvod;
        result = 31 * result + idMagacin;
        result = 31 * result + kolichina;
        return result;
    }
}
