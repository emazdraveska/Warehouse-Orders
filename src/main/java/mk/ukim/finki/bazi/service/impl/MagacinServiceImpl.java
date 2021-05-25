package mk.ukim.finki.bazi.service.impl;

import mk.ukim.finki.bazi.model.MagacinEntity;
import mk.ukim.finki.bazi.model.SiteMagaciniEntity;
import mk.ukim.finki.bazi.model.exceptions.WarehouseNotFoundException;
import mk.ukim.finki.bazi.repository.MagacinRepository;
import mk.ukim.finki.bazi.repository.SiteMagaciniRepository;
import mk.ukim.finki.bazi.service.MagacinService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MagacinServiceImpl implements MagacinService {
    private final MagacinRepository magacinRepository;
    private final SiteMagaciniRepository siteMagaciniRepository;

    public MagacinServiceImpl(MagacinRepository magacinRepository, SiteMagaciniRepository siteMagaciniRepository) {
        this.magacinRepository = magacinRepository;
        this.siteMagaciniRepository = siteMagaciniRepository;
    }

    @Override
    public MagacinEntity findByName(String imeMagacin) {
        return magacinRepository.findByImeMagacin(imeMagacin);
    }

    @Override
    public List<MagacinEntity> findAll() {
        return magacinRepository.findAll();
    }

    @Override
    public List<SiteMagaciniEntity> findAllSite() {
        return siteMagaciniRepository.findAll();
    }

    @Override
    public MagacinEntity save(MagacinEntity magacinEntity) {
        return magacinRepository.save(magacinEntity);
    }

    @Override
    public MagacinEntity findById(Integer warehouse) {
        return magacinRepository.findById(warehouse).orElseThrow(()->new WarehouseNotFoundException(warehouse));
    }
}
