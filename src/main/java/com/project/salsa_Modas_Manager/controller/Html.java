package com.project.salsa_Modas_Manager.controller;

import com.project.salsa_Modas_Manager.model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.math.BigDecimal;

@Controller
public class Html {

    @GetMapping("/home")
    public String home(Model model){
        Produto produto = new Produto();
        produto.setPrecoCompra(new BigDecimal(100L));

        model.addAttribute("pr",produto);
        return "/page";
    }
}
