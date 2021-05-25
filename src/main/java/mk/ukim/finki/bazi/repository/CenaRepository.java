package mk.ukim.finki.bazi.repository;

import mk.ukim.finki.bazi.model.CenaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface CenaRepository extends JpaRepository<CenaEntity, Date> {
}
