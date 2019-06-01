/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.facade;

import ec.edu.monster.modelo.Empleado;
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
public class EmpleadoFacade extends AbstractFacade<Empleado> {

    @PersistenceContext(unitName = "MonsterPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpleadoFacade() {
        super(Empleado.class);
    }
    
    public Empleado iniciarSesion(Empleado emp){
        Empleado empleado=null;
        String consulta;
        try{
            consulta= "FROM Empleado e WHERE e.empId= ?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1,emp.getEmpId());
            List<Empleado> lista= query.getResultList();
            if(!lista.isEmpty()){
                empleado=lista.get(0);
            }
        }catch(Exception e){ 
            throw e;
        }  
        return empleado;
    }
    public List<Empleado> buscar(Empleado emp){
        List<Empleado> lista=null;
        String consulta;
        try{
            consulta= "FROM Empleado e WHERE e.empNombre like ?1%";
            Query query = em.createQuery(consulta);
            query.setParameter(1,emp.getEmpCedula());
            lista= query.getResultList(); 
        }catch(Exception e){
            throw e;
        }  
        return lista;
    }
    
}
