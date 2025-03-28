package me.fit.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.fit.model.Jelo;
import java.util.List;

@Dependent
public class JeloRepository {
    @Inject
    EntityManager em;

    @Transactional
    public Jelo createJelo(Jelo j){
        return em.merge(j);
    }

    @Transactional
    public List<Jelo> getAllJela(){
        return em.createNamedQuery(Jelo.GET_ALL_JELA, Jelo.class).getResultList();
    }
}
