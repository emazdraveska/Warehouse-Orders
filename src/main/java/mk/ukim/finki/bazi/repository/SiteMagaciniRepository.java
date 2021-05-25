package mk.ukim.finki.bazi.repository;

import mk.ukim.finki.bazi.model.SiteMagaciniEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteMagaciniRepository extends JpaRepository<SiteMagaciniEntity, String> {
}
