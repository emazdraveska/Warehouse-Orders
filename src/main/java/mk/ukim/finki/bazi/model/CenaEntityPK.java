package mk.ukim.finki.bazi.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

public class CenaEntityPK implements Serializable {
    private Date vazhiOd;
    private int idProizvod;

    @Column(name = "vazhi_od")
    @Id
    public Date getVazhiOd() {
        return vazhiOd;
    }

    public void setVazhiOd(Date vazhiOd) {
        this.vazhiOd = vazhiOd;
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

        CenaEntityPK that = (CenaEntityPK) o;

        if (idProizvod != that.idProizvod) return false;
        if (vazhiOd != null ? !vazhiOd.equals(that.vazhiOd) : that.vazhiOd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = vazhiOd != null ? vazhiOd.hashCode() : 0;
        result = 31 * result + idProizvod;
        return result;
    }
}
