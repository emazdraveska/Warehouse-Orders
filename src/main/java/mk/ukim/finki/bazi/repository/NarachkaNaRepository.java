package mk.ukim.finki.bazi.repository;

import mk.ukim.finki.bazi.model.NarachkaNaEntity;
import mk.ukim.finki.bazi.model.NarachkaNaEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NarachkaNaRepository extends JpaRepository<NarachkaNaEntity, NarachkaNaEntityPK> {
}
