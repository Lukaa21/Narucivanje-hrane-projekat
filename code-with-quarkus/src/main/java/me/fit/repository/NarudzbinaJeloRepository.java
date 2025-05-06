package me.fit.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.fit.model.NarudzbinaJelo;

@Dependent
public class NarudzbinaJeloRepository {
    @Inject
    EntityManager em;

    @Transactional
    public NarudzbinaJelo createNarudzbinaJelo (NarudzbinaJelo nj){
        return em.merge(nj);
    }
}
