package mk.ukim.finki.bazi.service;

import mk.ukim.finki.bazi.model.NarachkaEntity;
import mk.ukim.finki.bazi.model.NarachkaNaEntity;
import mk.ukim.finki.bazi.model.SiteNarachkiEntity;

import java.sql.Timestamp;
import java.util.List;

public interface NarachkaService {
    List<NarachkaEntity> listAll();

    List<SiteNarachkiEntity> listAllSite();


    List<NarachkaEntity> listAllBy(Iterable<Integer> id);

    void save(int quantity,int idProizvod,int idNarachka, int idMagacin, int idProdavnica, Timestamp timestamp);
}
