package ma.millergraphics.it.Stock.model.service;

import ma.millergraphics.it.Stock.model.bo.Utilisateur;

public interface UtilisateurService {

    Utilisateur loadByUsername(String username);
}
