package mk.ukim.finki.bazi.web;

import mk.ukim.finki.bazi.model.MagacinEntity;
import mk.ukim.finki.bazi.model.SiteMagaciniEntity;
import mk.ukim.finki.bazi.repository.MagacinRepository;
import mk.ukim.finki.bazi.service.MagacinService;
import org.h2.engine.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.management.modelmbean.ModelMBeanOperationInfo;
import java.util.List;

@Controller
@RequestMapping("/warehouses")
public class MagacinController {
    private final MagacinService magacinService;

    public MagacinController(MagacinService magacinService) {
        this.magacinService = magacinService;
    }

    @GetMapping
    private String getWarehousePage(Model model){
        List<MagacinEntity> magacini = magacinService.findAll();
        List<SiteMagaciniEntity> mags = magacinService.findAllSite();

        model.addAttribute("magacini", magacini);
        model.addAttribute("mags", mags);
        model.addAttribute("bodyContent", "magacini");
        return "master-template";
    }

    @GetMapping("/add")
    // @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getAddWarehousePage(Model model) {
        model.addAttribute("bodyContent", "add-warehouse");
        return "master-template";
    }

    @PostMapping("/add")
    // @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String saveWarehouse(@RequestParam String name,
                                @RequestParam String address) {
        MagacinEntity posleden = magacinService.findAll().get(magacinService.findAll().size()-1);
        Integer id = posleden.getIdMagacin()+1;

        MagacinEntity magacinEntity = new MagacinEntity();
        magacinEntity.setIdMagacin(id);
        magacinEntity.setAdresaMagacin(address);
        magacinEntity.setImeMagacin(name);
        magacinService.save(magacinEntity);
        return "redirect:/warehouses";
    }
}
