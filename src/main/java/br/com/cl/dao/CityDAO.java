/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cl.dao;

import br.com.cl.persistence.LocalEntityManagerFactory;
import br.com.restful.entities.Campos;
import br.com.restful.entities.City;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author eric
 */
public class CityDAO {

    public List<Campos> getFieldsByCity(String city) {
        long start = System.currentTimeMillis();
        System.out.println("City search started");
        EntityManager em = LocalEntityManagerFactory.createEntityManager();
        try {
            TypedQuery<City> fieldsNQ = em.createNamedQuery("City.findByName", City.class);
            fieldsNQ.setParameter("name", city);

            Collection<Campos> camposCollection = fieldsNQ.getSingleResult().getCamposCollection();
            return new ArrayList<Campos>(camposCollection);

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Campos>();
        } finally {
            em.close();
            System.out.println("Getting data took " + (System.currentTimeMillis() - start) + "ms.");
        }
    }
}
