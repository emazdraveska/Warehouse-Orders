package mk.ukim.finki.bazi.repository;

import mk.ukim.finki.bazi.model.SiteNarachkiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiteNarachkiRepository extends JpaRepository<SiteNarachkiEntity, String> {
}
