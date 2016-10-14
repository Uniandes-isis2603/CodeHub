/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.codehub.audiovisuales.persistence;

import co.edu.uniandes.codehub.audiovisuales.entities.UsuarioEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import static javax.ws.rs.client.Entity.entity;

/**
 *
 * @author ln.bello10
 */
public class UsuarioPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(EdificioPersistence.class.getName());

    @PersistenceContext(unitName = "CodehubPU")
    protected EntityManager em;  
    
     public UsuarioEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando usuario con id={0}", id);
        return em.find(UsuarioEntity.class, id);
    }
     
     public UsuarioEntity findByName(String name){
         LOGGER.log(Level.INFO, "Consultando usuario con name= ", name);
         TypedQuery<UsuarioEntity> q = em.createQuery("SELECT u FROM UsuarioEntity u where u.name= :name",UsuarioEntity.class);
         q = q.setParameter("name", name);
         return q.getSingleResult();
     }
     
     public List<UsuarioEntity> findAll(){
         LOGGER.log(Level.INFO,"Consultando todos los usuario");
         Query q = em.createQuery("select u from UsuarioEntity u");
         return q.getResultList();
     }
     
     public UsuarioEntity create(UsuarioEntity entity){
         LOGGER.log(Level.INFO, "Creando un nuevo usuario");
         em.persist(entity);
         LOGGER.info("Usuario creado");
        return entity;
     }
     
     public UsuarioEntity update(UsuarioEntity entity){
         LOGGER.log(Level.INFO, "Actualizando usuario con id={0}", entity.getId());
         return em.merge(entity);
     }
     
     public void delete(Long id){
         LOGGER.log(Level.INFO, "Borrando usuario con id={0}",id);
         UsuarioEntity entity = em.find(UsuarioEntity.class, id);
         em.remove(entity);
     }
}