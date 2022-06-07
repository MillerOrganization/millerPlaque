package ma.millergraphics.it.Stock.model.service;

import lombok.AllArgsConstructor;
import ma.millergraphics.it.Stock.model.bo.Utilisateur;
import ma.millergraphics.it.Stock.model.dao.UtilisateurRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService{
    private UtilisateurRepository utilisateurRepository;

    @Override
    public Utilisateur loadByUsername(String username) {
        Utilisateur user=utilisateurRepository.findByUsernameOrMail(username,username);
        return user;
    }
}
