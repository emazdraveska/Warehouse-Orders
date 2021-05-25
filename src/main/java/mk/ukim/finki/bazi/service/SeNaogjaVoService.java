package mk.ukim.finki.bazi.service;

import mk.ukim.finki.bazi.model.NarachkaNaEntity;
import mk.ukim.finki.bazi.model.SeNaogjaVoEntity;

public interface SeNaogjaVoService {

    SeNaogjaVoEntity findByProizvodAndMagacin(Integer idProizvod, Integer idMagacin);

    SeNaogjaVoEntity save(Integer idProizvod, Integer warehouse, Integer quantity);
}
