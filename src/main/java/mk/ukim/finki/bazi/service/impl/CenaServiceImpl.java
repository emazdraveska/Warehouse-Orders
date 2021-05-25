package mk.ukim.finki.bazi.service.impl;

import mk.ukim.finki.bazi.model.CenaEntity;
import mk.ukim.finki.bazi.repository.CenaRepository;
import mk.ukim.finki.bazi.service.CenaService;
import org.springframework.boot.autoconfigure.web.servlet.JspTemplateAvailabilityProvider;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class CenaServiceImpl implements CenaService {
    private final CenaRepository cenaRepository;

    public CenaServiceImpl(CenaRepository cenaRepository) {
        this.cenaRepository = cenaRepository;
    }

    @Override
    public CenaEntity save(Date date, Integer idProizvod, Integer price) {
        CenaEntity cena = new CenaEntity();
        cena.setIdProizvod(idProizvod);
        cena.setVazhiOd(date);
        cena.setVrednost(price);
        cena.setVazhiDo(null);
        return cenaRepository.save(cena);
    }

    @Override
    public List<CenaEntity> findAll() {
        return cenaRepository.findAll();
    }
}
