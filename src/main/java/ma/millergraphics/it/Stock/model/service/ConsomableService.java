package ma.millergraphics.it.Stock.model.service;

import ma.millergraphics.it.Stock.model.bo.Consomable;

import java.util.Collection;

public interface ConsomableService {

    Collection<Consomable> getConsomables();

    Consomable getConsomableByListConsomable(String listConsomable);

}
