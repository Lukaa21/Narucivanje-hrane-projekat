package me.fit.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.fit.model.Dostavljac;
import java.util.List;

@Dependent
public class DostavljacRepository {
    @Inject
    EntityManager em;

    @Transactional
    public Dostavljac createDostavljac(Dostavljac d) {
        return em.merge(d);
    }

    @Transactional
    public List<Dostavljac> getAllDostavljaci(){
        return em.createNamedQuery(Dostavljac.GET_ALL_DOSTAVLJACI, Dostavljac.class).getResultList();
    }
}
