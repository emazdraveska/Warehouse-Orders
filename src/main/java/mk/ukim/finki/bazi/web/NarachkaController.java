package mk.ukim.finki.bazi.web;

import mk.ukim.finki.bazi.model.*;
import mk.ukim.finki.bazi.model.exceptions.InvalidArgumentsException;
import mk.ukim.finki.bazi.model.exceptions.QuantityException;
import mk.ukim.finki.bazi.model.exceptions.UsernameExistsException;
import mk.ukim.finki.bazi.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class NarachkaController {
    private final NarachkaService narachkaService;
    private final ProdavnicaService prodavnicaService;
    private final ProizvodService proizvodService;
    private final MagacinService magacinService;

    public NarachkaController(NarachkaService narachkaService, ProdavnicaService prodavnicaService, ProizvodService proizvodService, MagacinService magacinService) {
        this.narachkaService = narachkaService;
        this.prodavnicaService = prodavnicaService;
        this.proizvodService = proizvodService;
        this.magacinService = magacinService;
    }

    @GetMapping
    public String getOrdersPage(Model model) {
        List<NarachkaEntity> narachkiBy = narachkaService.listAll();
        List<SiteNarachkiEntity> siteNarachki = narachkaService.listAllSite();
        List<ProdavnicaMaloprodazhbaEntity> prodavnici = prodavnicaService.listAll();
        List<MagacinEntity> magacini = magacinService.findAll();
        model.addAttribute("narachki", narachkiBy);
        model.addAttribute("site", siteNarachki);
        model.addAttribute("prodavnici", prodavnici);
        model.addAttribute("magacini", magacini);
        model.addAttribute("bodyContent", "narachki");
        return "master-template";
    }

    @GetMapping("/{id}")
    public String getOrdersPage(@PathVariable Integer id,
                                Model model) {
        String prodavnica = prodavnicaService.findById(id).getImeProdavnica();
        List<NarachkaEntity> narachkiBy = narachkaService.listAll();
        List<SiteNarachkiEntity> siteNarachki = narachkaService.listAllSite();
        List<MagacinEntity> magacini = magacinService.findAll();
        model.addAttribute("prodavnica", prodavnica);
        model.addAttribute("narachki", narachkiBy);
        model.addAttribute("id", id);
        model.addAttribute("site", siteNarachki);
        model.addAttribute("magacini", magacini);
        model.addAttribute("bodyContent", "narachki");
        return "master-template";
    }

    @GetMapping("/add")
    public String getAddStorePage(Model model) {
        List<ProdavnicaMaloprodazhbaEntity> prodavnici = prodavnicaService.listAll();
        model.addAttribute("prodavnici", prodavnici);
        model.addAttribute("bodyContent", "narachki-prodavnica");
        return "master-template";
    }

    @PostMapping("/add")
    public String addStorePage(@RequestParam Integer idProdavnica,
                               HttpServletRequest req) {
        req.getSession().setAttribute("idProdavnica", idProdavnica);
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        req.getSession().setAttribute("timestamp", timestamp);

        NarachkaEntity posledna = narachkaService.listAll().get(narachkaService.listAll().size() - 1);
        Integer idNarachka = posledna.getIdNarachka() + 1;
        req.getSession().setAttribute("idNarachka", idNarachka);
        return "redirect:/orders/add-order";
    }

    @GetMapping("/add-order")
    public String getAddOrderPage(Model model, HttpServletRequest req) {
        List<SiteProizvodiEntity> proizvodi = proizvodService.listAllSite();
        model.addAttribute("proizvodi", proizvodi);
        model.addAttribute("bodyContent", "narachki-proizvodi");
        return "master-template";
    }

    @PostMapping("/add-order/{proizvod}")
    public String addStorePage(@PathVariable String proizvod,
                               @RequestParam int quantity,
                               HttpServletRequest req, Model model) {
        int idProdavnica = (int) req.getSession().getAttribute("idProdavnica");
        Timestamp timestamp = (Timestamp) req.getSession().getAttribute("timestamp");
        int idNarachka = (int) req.getSession().getAttribute("idNarachka");

        int idProizvod = proizvodService.findById(proizvod).getIdProizvod();
        String imeMagacin = proizvodService.findById(proizvod).getImeMagacin();
        int idMagacin = magacinService.findByName(imeMagacin).getIdMagacin();

        try {

            narachkaService.save(quantity, idProizvod, idNarachka, idMagacin, idProdavnica, timestamp);
            List<SiteProizvodiEntity> proizvodi = proizvodService.listAllSite();
            model.addAttribute("proizvodi", proizvodi);
            model.addAttribute("bodyContent", "narachki-proizvodi");
            return "master-template";

        } catch (QuantityException exception) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
             List<SiteProizvodiEntity> proizvodi = proizvodService.listAllSite();
                        model.addAttribute("proizvodi", proizvodi);
            model.addAttribute("bodyContent", "narachki-proizvodi");
            return "master-template";
        }

    }
}

