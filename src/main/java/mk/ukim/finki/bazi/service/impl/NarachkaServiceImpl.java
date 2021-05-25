package mk.ukim.finki.bazi.service.impl;

import mk.ukim.finki.bazi.model.NarachkaEntity;
import mk.ukim.finki.bazi.model.NarachkaNaEntity;
import mk.ukim.finki.bazi.model.SiteNarachkiEntity;
import mk.ukim.finki.bazi.model.exceptions.QuantityException;
import mk.ukim.finki.bazi.repository.NarachkaNaRepository;
import mk.ukim.finki.bazi.repository.NarachkaRepository;
import mk.ukim.finki.bazi.repository.SiteNarachkiRepository;
import mk.ukim.finki.bazi.service.NarachkaService;
import mk.ukim.finki.bazi.service.SeNaogjaVoService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class NarachkaServiceImpl implements NarachkaService {
    private final NarachkaRepository narachkaRepository;
    private final SiteNarachkiRepository siteNarachkiRepository;
    private final NarachkaNaRepository narachkaNaRepository;
    private final SeNaogjaVoService seNaogjaVoService;

    public NarachkaServiceImpl(NarachkaRepository narachkaRepository, SiteNarachkiRepository siteNarachkiRepository, NarachkaNaRepository narachkaNaRepository, SeNaogjaVoService seNaogjaVoService) {
        this.narachkaRepository = narachkaRepository;
        this.siteNarachkiRepository = siteNarachkiRepository;
        this.narachkaNaRepository = narachkaNaRepository;
        this.seNaogjaVoService = seNaogjaVoService;
    }

    @Override
    public List<NarachkaEntity> listAll() {
        return narachkaRepository.findAll();
    }

    @Override
    public List<SiteNarachkiEntity> listAllSite() {
        return siteNarachkiRepository.findAll();
    }

    @Override
    public void save(int quantity, int idProizvod, int idNarachka, int idMagacin, int idProdavnica, Timestamp timestamp) {
        if (quantity >= this.seNaogjaVoService.findByProizvodAndMagacin(idProizvod,idMagacin).getKolichina())
            throw new QuantityException();
        
        NarachkaEntity narachka = new NarachkaEntity();
        narachka.setIdNarachka(idNarachka);
        narachka.setIdMagacin(idMagacin);
        narachka.setIdProdavnica(idProdavnica);
        narachka.setDatumNarachka(timestamp);

        narachkaRepository.save(narachka);

        NarachkaNaEntity narachkaNa = new NarachkaNaEntity();
        narachkaNa.setIdProizvod(idProizvod);
        narachkaNa.setIdNarachka(idNarachka);
        narachkaNa.setKolichina(quantity);

        seNaogjaVoService.findByProizvodAndMagacin(idProizvod, idMagacin).setKolichina(seNaogjaVoService
                .findByProizvodAndMagacin(idProizvod, idMagacin).getKolichina() - quantity);
        narachkaNaRepository.save(narachkaNa);

    }

    @Override
    public List<NarachkaEntity> listAllBy(Iterable<Integer> id) {
        return narachkaRepository.findAllById(id);
    }
}
