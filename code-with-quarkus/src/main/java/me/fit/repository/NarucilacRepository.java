package me.fit.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.fit.model.Narucilac;
import java.util.List;

@Dependent
public class NarucilacRepository {
    @Inject
    EntityManager em;

    @Transactional
    public Narucilac createNarucilac(Narucilac narucilac) {
        return em.merge(narucilac);
    }

    @Transactional
    public List<Narucilac> getAllNarucioci(){
        return em.createNamedQuery(Narucilac.GET_ALL_NARUCIOCI, Narucilac.class).getResultList();
    }
}
