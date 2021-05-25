package mk.ukim.finki.bazi.model;

import mk.ukim.finki.bazi.service.NarachkaService;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "narachka", schema = "public", catalog = "magacin")
public class NarachkaEntity {

    private int idNarachka;
    private int idProdavnica;
    private int idMagacin;
    private Timestamp datumNarachka;

    @Id
    @Column(name = "id_narachka")
    public int getIdNarachka() {
        return idNarachka;
    }

    public void setIdNarachka(int idNarachka) {
        this.idNarachka = idNarachka;
    }

    @Basic
    @Column(name = "id_prodavnica")
    public int getIdProdavnica() {
        return idProdavnica;
    }

    public void setIdProdavnica(int idProdavnica) {
        this.idProdavnica = idProdavnica;
    }

    @Basic
    @Column(name ="id_magacin")
    public int getIdMagacin() {
        return idMagacin;
    }

    public void setIdMagacin(int idMagacin) {
        this.idMagacin = idMagacin;
    }

    @Basic
    @Column(name = "datum_narachka")
    public Timestamp getDatumNarachka() {
        return datumNarachka;
    }

    public void setDatumNarachka(Timestamp datumNarachka) {
        this.datumNarachka = datumNarachka;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NarachkaEntity that = (NarachkaEntity) o;
        return idNarachka == that.idNarachka &&
                idProdavnica == that.idProdavnica &&
                idMagacin == that.idMagacin &&
                Objects.equals(datumNarachka, that.datumNarachka);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNarachka, idProdavnica, idMagacin, datumNarachka);
    }

}
