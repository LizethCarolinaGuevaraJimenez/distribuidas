/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.facade;

import ec.edu.monster.modelo.PeempEmpleado;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jonathan
 */
@Stateless
public class EmpleadoFacade extends AbstractFacade<PeempEmpleado> {

    @PersistenceContext(unitName = "MonsterPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpleadoFacade() {
        super(PeempEmpleado.class);
    }
    
    public PeempEmpleado iniciarSesion(PeempEmpleado emp){
        PeempEmpleado empleado=null;
        String consulta;
        try{
            consulta= "FROM Empleado e WHERE e.empId= ?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1,emp.getPeempId());
            List<PeempEmpleado> lista= query.getResultList();
            if(!lista.isEmpty()){
                empleado=lista.get(0);
            }
        }catch(Exception e){ 
            throw e;
        }  
        return empleado;
    }
    public List<PeempEmpleado> buscar(PeempEmpleado emp){
        List<PeempEmpleado> lista=null;
        String consulta;
        try{
            consulta= "FROM PeempEmpleado e WHERE e.empNombre like ?1%";
            Query query = em.createQuery(consulta);
            query.setParameter(1,emp.getPeempCedula());
            lista= query.getResultList(); 
        }catch(Exception e){
            throw e;
        }  
        return lista;
    }
    
}
