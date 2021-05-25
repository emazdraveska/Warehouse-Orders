package mk.ukim.finki.bazi.repository;

import jdk.jfr.Registered;
import mk.ukim.finki.bazi.model.SiteProdavniciEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface SiteProdavniciRepository extends JpaRepository<SiteProdavniciEntity, String> {
}
