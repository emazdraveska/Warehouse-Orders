package mk.ukim.finki.bazi.repository;

import mk.ukim.finki.bazi.model.ProizvodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProizvodRepository extends JpaRepository<ProizvodEntity, Integer> {
}
