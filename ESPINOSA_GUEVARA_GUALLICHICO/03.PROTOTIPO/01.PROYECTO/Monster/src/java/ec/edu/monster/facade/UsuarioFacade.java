/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.facade;

import ec.edu.monster.modelo.PeempEmpleado;
import ec.edu.monster.modelo.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Jonathan
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "MonsterPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    public List<Usuario> contrasena(Usuario us) { 
        String consulta;
        String encriptacion = DigestUtils.sha512Hex(us.getUsuContrasena());
        try {
            consulta = "FROM Usuario u WHERE u.usuContrasena= ?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, encriptacion);
            List<Usuario> lista = query.getResultList();
            return lista;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Usuario> usuariosTodos() {
        String consulta;
        try {
            consulta = "FROM Usuario u";
            Query query = em.createQuery(consulta);
            List<Usuario> lista = query.getResultList();
            return lista;
        } catch (Exception e) {
            throw e;
        }
    }

}
