package me.fit.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.fit.model.Narudzbina;
import java.util.List;

@Dependent
public class NarudzbinaRepository {
    @Inject
    EntityManager em;

    @Transactional
    public Narudzbina createNarudzbina(Narudzbina n) {
        return em.merge(n);
    }

    @Transactional
    public List<Narudzbina> getAllNarudzbine() {
        return em.createNamedQuery(Narudzbina.GET_ALL_NARUDZBINE, Narudzbina.class).getResultList();
    }
}
