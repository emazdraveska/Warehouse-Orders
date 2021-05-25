package mk.ukim.finki.bazi.repository;

import mk.ukim.finki.bazi.model.NarachkaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface NarachkaRepository extends JpaRepository<NarachkaEntity, Integer> {

}
