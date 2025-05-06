package me.fit.repository;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import me.fit.model.Narudzbina;
import jakarta.persistence.EntityManager;

public class NarudzbinaRepository {
    @Inject
    EntityManager em;

    @Transactional
    public Narudzbina createNarudzbina(Narudzbina n){
        return em.merge(n);
    }

}
