/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.facade;

import ec.edu.monster.modelo.OpcionPerfil;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pablo
 */
@Stateless
public class OpcionPerfilFacade extends AbstractFacade<OpcionPerfil> {

    @PersistenceContext(unitName = "monsterUniverPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OpcionPerfilFacade() {
        super(OpcionPerfil.class);
    }
    
}
