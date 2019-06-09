/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.facade;

import ec.edu.monster.modelo.Empleado;
import ec.edu.monster.modelo.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author pablo
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "monsterUniverPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    
 //////////////METODOS AGREGADOS ////////////////////   
    public Usuario prueba(){
        return new Usuario();
    }
     public Usuario iniciarSesion(Usuario usu){
        System.out.println("FACADE");
        Usuario usuario=null;
        String consulta;
        String encriptado=DigestUtils.sha512Hex(   usu.getSeusuContrasena() ) ;
        try{
            consulta= "FROM Usuario u WHERE u.seusuUsuario= ?1 and u.seusuContrasena= ?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1,usu.getSeusuUsuario());
            query.setParameter(2,encriptado  ); 
            List<Usuario> lista= query.getResultList();
            if(!lista.isEmpty()){
                usuario=lista.get(0);
            }
        }catch(Exception e){ 
            throw e;
        }  
        return usuario;
    }
     
     
//    public List<Usuario> buscar(Usuario usu){
//        List<Usuario> lista=null;
//        String consulta;
//        try{
//            consulta= "FROM Empleado e WHERE e.peempNomres like ?1%";
//            Query query = em.createQuery(consulta);
//            query.setParameter(1,usu.getPeempCedula());
//            lista= query.getResultList(); 
//        }catch(Exception e){
//            throw e;
//        }  
//        return lista;
//    }
     
  
 //////////////METODOS AGREGADOS ////////////////////
}
