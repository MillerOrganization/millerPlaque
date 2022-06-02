package ma.millergraphics.it.Stock.model.service;

import lombok.AllArgsConstructor;
import ma.millergraphics.it.Stock.model.bo.Consomable;
import ma.millergraphics.it.Stock.model.bo.ListConsomable;
import ma.millergraphics.it.Stock.model.dao.ConsomableRepository;
import ma.millergraphics.it.Stock.model.dao.ListConsomableRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class ConsomableServiceImpl implements ConsomableService{
    private ConsomableRepository consomableRepository;
    private ListConsomableRepository listConsomableRepository;
    @Override
    public Collection<Consomable> getConsomables() {
        Collection<Consomable> consomables=consomableRepository.findAll();
        consomables.forEach(consomable -> {
            consomable.calculerDifference();
        });
        return consomables;
    }

    @Override
    public Consomable getConsomableByListConsomable(String lc) {
        ListConsomable listConsomable=listConsomableRepository.findByDesignation(lc);
        return consomableRepository.findByListConsomable(listConsomable);
    }
}
