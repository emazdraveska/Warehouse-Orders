package mk.ukim.finki.bazi.service;

import mk.ukim.finki.bazi.model.MagacinEntity;
import mk.ukim.finki.bazi.model.NarachkaEntity;
import mk.ukim.finki.bazi.model.SiteMagaciniEntity;

import java.util.List;

public interface MagacinService {
    MagacinEntity findByName(String imeMagacin);

    List<MagacinEntity> findAll();

    List<SiteMagaciniEntity> findAllSite();

    MagacinEntity save(MagacinEntity magacinEntity);

    MagacinEntity findById(Integer warehouse);
}
