package mk.ukim.finki.bazi.service.impl;

import mk.ukim.finki.bazi.model.SeNaogjaVoEntity;
import mk.ukim.finki.bazi.repository.SeNaogjaVoRepository;
import mk.ukim.finki.bazi.service.SeNaogjaVoService;
import org.springframework.stereotype.Service;

@Service
public class SeNaogjaVoServiceImpl implements SeNaogjaVoService {
    private final SeNaogjaVoRepository seNaogjaVoRepository;

    public SeNaogjaVoServiceImpl(SeNaogjaVoRepository seNaogjaVoRepository) {
        this.seNaogjaVoRepository = seNaogjaVoRepository;
    }

    @Override
    public SeNaogjaVoEntity findByProizvodAndMagacin(Integer idProizvod, Integer idMagacin) {
        return seNaogjaVoRepository.findByIdProizvodAndIdMagacin(idProizvod,idMagacin);
    }

    @Override
    public SeNaogjaVoEntity save(Integer idProizvod, Integer warehouse, Integer quantity) {
        SeNaogjaVoEntity seNaogjaVoEntity = new SeNaogjaVoEntity();
        seNaogjaVoEntity.setKolichina(quantity);
        seNaogjaVoEntity.setIdProizvod(idProizvod);
        seNaogjaVoEntity.setIdMagacin(warehouse);
        return seNaogjaVoRepository.save(seNaogjaVoEntity);
    }
}
