package mk.ukim.finki.bazi.service;

import mk.ukim.finki.bazi.model.ProdavnicaMaloprodazhbaEntity;
import mk.ukim.finki.bazi.model.SiteProdavniciEntity;

import java.util.List;

public interface ProdavnicaService {

    List<SiteProdavniciEntity> listAllView();

    List<ProdavnicaMaloprodazhbaEntity> listAll();

    ProdavnicaMaloprodazhbaEntity findById(Integer id);

    ProdavnicaMaloprodazhbaEntity save(ProdavnicaMaloprodazhbaEntity prodavnica);
}
