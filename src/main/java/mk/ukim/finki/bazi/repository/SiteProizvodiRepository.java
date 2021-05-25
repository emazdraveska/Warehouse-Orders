package mk.ukim.finki.bazi.repository;

import mk.ukim.finki.bazi.model.SiteProizvodiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface SiteProizvodiRepository extends JpaRepository<SiteProizvodiEntity, String> {
}
