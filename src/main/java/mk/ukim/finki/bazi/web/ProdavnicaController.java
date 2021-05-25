package mk.ukim.finki.bazi.web;

import mk.ukim.finki.bazi.model.MagacinEntity;
import mk.ukim.finki.bazi.model.ProdavnicaMaloprodazhbaEntity;
import mk.ukim.finki.bazi.model.SiteProdavniciEntity;
import mk.ukim.finki.bazi.service.ProdavnicaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/stores")
public class ProdavnicaController {
    private final ProdavnicaService prodavnicaService;

    public ProdavnicaController(ProdavnicaService prodavnicaService) {
        this.prodavnicaService = prodavnicaService;
    }

    @GetMapping
    public String getStoresPage (Model model){
        List<SiteProdavniciEntity> siteProdavnici = prodavnicaService.listAllView();
        List<ProdavnicaMaloprodazhbaEntity> prodavnici = prodavnicaService.listAll();
        model.addAttribute("siteProdavnici", siteProdavnici);
        model.addAttribute("prodavnici", prodavnici);
        model.addAttribute("bodyContent", "prodavnici");
        return "master-template";
    }

    @GetMapping("/add")
    // @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addStore(Model model) {
        model.addAttribute("bodyContent", "add-prodavnica");
        return "master-template";
    }

    @PostMapping("/add")
    // @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String saveStore(@RequestParam String name,
                                @RequestParam String tip,
                                @RequestParam String address) {
        ProdavnicaMaloprodazhbaEntity posleden = prodavnicaService.listAll().get(prodavnicaService.listAll().size()-1);
        Integer id = posleden.getIdProdavnica()+1;

        ProdavnicaMaloprodazhbaEntity prodavnica = new ProdavnicaMaloprodazhbaEntity();
        prodavnica.setTipProdavnica(tip);
        prodavnica.setAdresaProdavnica(address);
        prodavnica.setImeProdavnica(name);
        prodavnica.setIdProdavnica(id);

        prodavnicaService.save(prodavnica);
        return "redirect:/stores";
    }
}
