package mk.ukim.finki.bazi.service;

import mk.ukim.finki.bazi.model.CenaEntity;

import java.sql.Date;
import java.util.List;

public interface CenaService {
    CenaEntity save(Date date, Integer idProizvod, Integer price);

    List<CenaEntity> findAll();
}
