package mk.ukim.finki.bazi.web;

import mk.ukim.finki.bazi.model.*;
import mk.ukim.finki.bazi.service.CenaService;
import mk.ukim.finki.bazi.service.MagacinService;
import mk.ukim.finki.bazi.service.ProizvodService;
import mk.ukim.finki.bazi.service.SeNaogjaVoService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.PrivateKey;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/products")
public class ProizvodController {
    private final ProizvodService proizvodService;
    private final CenaService cenaService;
    private final MagacinService magacinService;
    private final SeNaogjaVoService seNaogjaVoService;

    public ProizvodController(ProizvodService proizvodService, CenaService cenaService, MagacinService magacinService, SeNaogjaVoService seNaogjaVoService) {
        this.proizvodService = proizvodService;
        this.cenaService = cenaService;
        this.magacinService = magacinService;
        this.seNaogjaVoService = seNaogjaVoService;
    }

    @GetMapping
    public String getProductsPage(Model model) {
        List<ProizvodEntity> proizvodi = proizvodService.listAll();
        List<CenaEntity> cena = cenaService.findAll();
//        List<SiteProizvodiEntity> list = removeDuplicates(site);
        model.addAttribute("proizvodi", proizvodi);
        model.addAttribute("cena", cena);
        model.addAttribute("bodyContent", "proizvodi");
        return "master-template";
    }

    @GetMapping("/add")
    // @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getAddProductPage(Model model) {
        List<MagacinEntity> magacini = magacinService.findAll();
        model.addAttribute("warehouses", magacini);
        model.addAttribute("bodyContent", "add-product");
        return "master-template";
    }

    @PostMapping("/add")
    // @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String saveProduct(@RequestParam String name,
                              @RequestParam String tip,
                              @RequestParam Integer price,
                              @RequestParam Integer quantity,
                              @RequestParam Integer warehouse) {
        ProizvodEntity posledenProizvod = proizvodService.listAll().get(proizvodService.listAll().size()-1);
        Integer idProizvod = posledenProizvod.getIdProizvod()+1;
        proizvodService.save(idProizvod,name,tip);

        java.sql.Date date = Date.valueOf(LocalDate.now());
        cenaService.save(date, idProizvod, price);

        seNaogjaVoService.save(idProizvod, warehouse, quantity);

        return "redirect:/products";
    }

//    @GetMapping("/edit/{id}")
//   // @PreAuthorize("hasRole('ROLE_ADMIN')")
//    public String getEditProductPage(@PathVariable Integer id, Model model) {
//        if (this.proizvodService.findById(id).isPresent()) {
//            ProizvodEntity product = this.proizvodService.findById(id).get();
//            model.addAttribute("product", product);
//            model.addAttribute("bodyContent", "add-product");
//            return "master-template";
//        }
//        return "redirect:/manufacturers?error=ManufacturerNotFound";
//    }

}