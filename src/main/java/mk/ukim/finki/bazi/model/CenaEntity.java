package mk.ukim.finki.bazi.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "cena", schema = "public", catalog = "magacin")
@IdClass(CenaEntityPK.class)
public class CenaEntity {
    private Date vazhiOd;
    private int idProizvod;
    private int vrednost;
    private Date vazhiDo;

    @Id
    @Column(name = "vazhi_od")
    public Date getVazhiOd() {
        return vazhiOd;
    }

    public void setVazhiOd(Date vazhiOd) {
        this.vazhiOd = vazhiOd;
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
    @Column(name = "vrednost")
    public int getVrednost() {
        return vrednost;
    }

    public void setVrednost(int vrednost) {
        this.vrednost = vrednost;
    }

    @Basic
    @Column(name = "vazhi_do")
    public Date getVazhiDo() {
        return vazhiDo;
    }

    public void setVazhiDo(Date vazhiDo) {
        this.vazhiDo = vazhiDo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CenaEntity that = (CenaEntity) o;

        if (idProizvod != that.idProizvod) return false;
        if (vrednost != that.vrednost) return false;
        if (vazhiOd != null ? !vazhiOd.equals(that.vazhiOd) : that.vazhiOd != null) return false;
        if (vazhiDo != null ? !vazhiDo.equals(that.vazhiDo) : that.vazhiDo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = vazhiOd != null ? vazhiOd.hashCode() : 0;
        result = 31 * result + idProizvod;
        result = 31 * result + vrednost;
        result = 31 * result + (vazhiDo != null ? vazhiDo.hashCode() : 0);
        return result;
    }
}
