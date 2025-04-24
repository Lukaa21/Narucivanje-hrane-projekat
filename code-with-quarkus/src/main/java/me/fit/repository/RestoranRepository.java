package me.fit.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.fit.model.Jelo;
import me.fit.exception.RestoranException;
import me.fit.model.Restoran;
import java.util.HashSet;
import java.util.List;

@Dependent
public class RestoranRepository {
    @Inject
    EntityManager em;

    @Transactional
    public Restoran createRestoran(Restoran restoran){
        return em.merge(restoran);
    }

    @Transactional
    public List <Restoran> getAllRestorani(){
        List <Restoran> restorani = em.createNamedQuery(Restoran.GET_ALL_RESTORANI, Restoran.class).getResultList();
        for (Restoran r : restorani) {
            List<Jelo> jela = em.createNamedQuery(Jelo.GET_JELA_FOR_RESTORAN, Jelo.class).setParameter("id", r.getId()).getResultList();
            r.setJela(new HashSet<>(jela));
        }
        return restorani;
    }

    public List<Restoran> getRestoraniByName(String naziv) throws RestoranException {
        List<Restoran> restorani = em.createNamedQuery(Restoran.GET_RESTORANI_BY_NAME, Restoran.class)
                .setParameter("naziv", naziv).getResultList();
        if (restorani.isEmpty()){
            throw new RestoranException("Ne postoje restorani sa datim nazivom");
        }
        return restorani;
    }
}