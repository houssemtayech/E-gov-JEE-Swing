package tn.esprit.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.ejb3.annotation.Clustered;

import tn.esprit.domain.Reclamation;
import tn.esprit.domain.Request;

/**
 * Session Bean implementation class RequestGestion
 */
@Stateful
@Clustered
@Remote(RequestGestionRemote.class)

@LocalBean
public class RequestGestion implements RequestGestionRemote, RequestGestionLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="egovernment")
    EntityManager em;
    public RequestGestion() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Request> findRequestByDepartement(String departement) {
		String requete="select t from Request t where t.departement=:departement";
		return em.createQuery(requete).setParameter("departement", departement).getResultList();
        
	}

	@Override
	public List<Request> findRequestByType(String service) {
		Query qr;
		qr= em.createQuery("select t from Request t where t.service=:service");
        qr.setParameter("service", service);
		
		return qr.getResultList();
			
	}

	@Override
	public Request findRequestById(int id) {
		Request rec = null;
		Query qr;
		try {
			qr= em.createQuery("SELECT c FROM Request c WHERE c.id=:id");
			qr.setParameter("id", id);
			rec=(Request) qr.getSingleResult();
			return rec;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Boolean RequestDone(int id) {
		
		return false;
	

}}
