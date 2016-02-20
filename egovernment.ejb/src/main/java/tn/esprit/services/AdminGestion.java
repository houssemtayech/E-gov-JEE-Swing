package tn.esprit.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.domain.Agent;
import tn.esprit.domain.Reclamation;

/**
 * Session Bean implementation class AdminGestion
 */
@Stateless
public class AdminGestion implements AdminGestionRemote {
	@PersistenceContext(name="egovernment")
	EntityManager em;
    public AdminGestion() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Reclamation> findReclamationByType() {
		String type="technique";
		Query query = em.createQuery("SELECT r FROM Reclamation r where r.type=:type");
		query.setParameter("type", type);
		
		return query.getResultList();
	}

	@Override
	public boolean deleteClaim(int id) {
		Reclamation ag;
		try {
			ag=findClaimById(id);
			
			em.remove(em.merge(ag));
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}


	@Override
	public List<Agent> findAgent() {
		
		Query qr=em.createQuery("SELECT u FROM Agent u");
			
			return qr.getResultList();
		
		
		
	}

	
	@Override
	public boolean updateAgent(int id, String login, String pwd, String role) {
		Agent ag;
		try {
			ag=findAgentById(id);
			ag.setLogin(login);
			ag.setPwd(pwd);
			ag.setRole(role);
			em.merge(ag);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean addAgent(Agent agent) {
		em.persist(agent);
		return true;
	}

	@Override
	public Agent findAgentById(int id) {
		Agent ag=null;
		try {
			ag=em.find(Agent.class, id);
			return ag;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ag;
	}

	@Override
	public boolean deleteAgent(int id) {
		Agent ag;
		try {
			ag=findAgentById(id);
			
			em.remove(em.merge(ag));
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public Reclamation findClaimById(int id) {
		Reclamation ag=null;
		try {
			ag=em.find(Reclamation.class, id);
			return ag;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ag;
	}

}
