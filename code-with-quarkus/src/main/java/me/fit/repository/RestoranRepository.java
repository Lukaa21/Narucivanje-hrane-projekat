package me.fit.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.fit.model.Restoran;
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
        return em.createNamedQuery(Restoran.GET_ALL_RESTORANI, Restoran.class).getResultList();
    }
}
