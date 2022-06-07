package ma.millergraphics.it.Stock.controller;

import lombok.AllArgsConstructor;
import ma.millergraphics.it.Stock.model.bo.Utilisateur;
import ma.millergraphics.it.Stock.model.service.UtilisateurService;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/utilisateur")
public class UtilisateurController {

    private UtilisateurService utilisateurService;


}
