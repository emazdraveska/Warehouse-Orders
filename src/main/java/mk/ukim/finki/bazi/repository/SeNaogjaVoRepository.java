package mk.ukim.finki.bazi.repository;

import mk.ukim.finki.bazi.model.SeNaogjaVoEntity;
import mk.ukim.finki.bazi.model.SeNaogjaVoEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.stereotype.Repository;

@Repository
public interface SeNaogjaVoRepository extends JpaRepository<SeNaogjaVoEntity, SeNaogjaVoEntityPK> {

    SeNaogjaVoEntity findByIdProizvodAndIdMagacin(Integer idProizvod, Integer idMagacin);
}
