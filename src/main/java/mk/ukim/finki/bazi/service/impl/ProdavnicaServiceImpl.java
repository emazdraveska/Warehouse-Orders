package mk.ukim.finki.bazi.service.impl;

import mk.ukim.finki.bazi.model.ProdavnicaMaloprodazhbaEntity;
import mk.ukim.finki.bazi.model.SiteProdavniciEntity;
import mk.ukim.finki.bazi.model.exceptions.StoreNotFoundException;
import mk.ukim.finki.bazi.repository.ProdavnicaRepository;
import mk.ukim.finki.bazi.repository.SiteProdavniciRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdavnicaServiceImpl implements mk.ukim.finki.bazi.service.ProdavnicaService {
    private final ProdavnicaRepository prodavnicaRepository;
    private final SiteProdavniciRepository siteProdavniciRepository;

    public ProdavnicaServiceImpl(ProdavnicaRepository prodavnicaRepository, SiteProdavniciRepository siteProdavniciRepository) {
        this.prodavnicaRepository = prodavnicaRepository;
        this.siteProdavniciRepository = siteProdavniciRepository;
    }

    @Override
    public List<SiteProdavniciEntity> listAllView() {
        return this.siteProdavniciRepository.findAll();
    }

    @Override
    public List<ProdavnicaMaloprodazhbaEntity> listAll() {
        return this.prodavnicaRepository.findAll();
    }

    @Override
    public ProdavnicaMaloprodazhbaEntity findById(Integer id) {
        return prodavnicaRepository.findById(id).orElseThrow(()-> new StoreNotFoundException(id));
    }

    @Override
    public ProdavnicaMaloprodazhbaEntity save(ProdavnicaMaloprodazhbaEntity prodavnica) {
        return prodavnicaRepository.save(prodavnica);
    }
}
