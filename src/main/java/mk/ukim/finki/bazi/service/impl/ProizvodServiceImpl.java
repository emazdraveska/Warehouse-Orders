package mk.ukim.finki.bazi.service.impl;

import mk.ukim.finki.bazi.model.ProizvodEntity;
import mk.ukim.finki.bazi.model.SiteProizvodiEntity;
import mk.ukim.finki.bazi.model.exceptions.ProductNotFoundException;
import mk.ukim.finki.bazi.repository.ProizvodRepository;
import mk.ukim.finki.bazi.repository.SiteProizvodiRepository;
import mk.ukim.finki.bazi.service.ProizvodService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProizvodServiceImpl implements  ProizvodService {
    private final SiteProizvodiRepository siteProizvodiRepository;
    private final ProizvodRepository proizvodRepository;

    public ProizvodServiceImpl(SiteProizvodiRepository siteProizvodiRepository, ProizvodRepository proizvodRepository) {
        this.siteProizvodiRepository = siteProizvodiRepository;
        this.proizvodRepository = proizvodRepository;
    }

    @Override
    public List<SiteProizvodiEntity> listAllSite() {
        return this.siteProizvodiRepository.findAll();
    }

    @Override
    public SiteProizvodiEntity findById(String idProizvod) {
        return siteProizvodiRepository.findById(idProizvod).orElseThrow(()->new ProductNotFoundException(idProizvod));
    }

    @Override
    public List<ProizvodEntity> listAll() {
        return proizvodRepository.findAll();
    }

    @Override
    public ProizvodEntity findById(Integer id) {
        return proizvodRepository.findById(id).orElseThrow(()-> new ProductNotFoundException(id));
    }

    @Override
    public ProizvodEntity save(Integer idProizvod, String name, String tip) {
        ProizvodEntity proizvod = new ProizvodEntity();
        proizvod.setIdProizvod(idProizvod);
        proizvod.setImeProizvod(name);
        proizvod.setTipProizvod(tip);
        return proizvodRepository.save(proizvod);
    }

}
