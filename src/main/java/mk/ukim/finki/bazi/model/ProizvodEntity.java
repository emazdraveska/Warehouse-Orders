package mk.ukim.finki.bazi.model;

import javax.persistence.*;

@Entity
@Table(name = "proizvod", schema = "public", catalog = "magacin")
public class ProizvodEntity {
    private int idProizvod;
    private String imeProizvod;
    private String tipProizvod;

    @Id
    @Column(name = "id_proizvod")
    public int getIdProizvod() {
        return idProizvod;
    }

    public void setIdProizvod(int idProizvod) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProizvodEntity that = (ProizvodEntity) o;

        if (idProizvod != that.idProizvod) return false;
        if (imeProizvod != null ? !imeProizvod.equals(that.imeProizvod) : that.imeProizvod != null) return false;
        if (tipProizvod != null ? !tipProizvod.equals(that.tipProizvod) : that.tipProizvod != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProizvod;
        result = 31 * result + (imeProizvod != null ? imeProizvod.hashCode() : 0);
        result = 31 * result + (tipProizvod != null ? tipProizvod.hashCode() : 0);
        return result;
    }


}
