package mk.ukim.finki.bazi.service;

import mk.ukim.finki.bazi.model.NarachkaEntity;
import mk.ukim.finki.bazi.model.ProizvodEntity;
import mk.ukim.finki.bazi.model.SiteProizvodiEntity;

import java.util.List;

public interface ProizvodService {
    List<SiteProizvodiEntity> listAllSite();

    SiteProizvodiEntity findById(String idProizvod);

    ProizvodEntity findById(Integer id);

    List<ProizvodEntity> listAll();

    ProizvodEntity save(Integer idProizvod, String name, String tip);

   }
