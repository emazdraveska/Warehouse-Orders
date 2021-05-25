package mk.ukim.finki.bazi.repository;

import mk.ukim.finki.bazi.model.ProdavnicaMaloprodazhbaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdavnicaRepository extends JpaRepository<ProdavnicaMaloprodazhbaEntity, Integer> {

}
