/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.facade;

import ec.edu.monster.modelo.Ventana;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pablo
 */
@Stateless
public class VentanaFacade extends AbstractFacade<Ventana> {

    @PersistenceContext(unitName = "monsterUniverPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VentanaFacade() {
        super(Ventana.class);
    }
    
}
