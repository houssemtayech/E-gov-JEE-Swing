package tn.esprit.services;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.domain.Agent;


@Stateful
public class AgentGestion implements AgentGestionRemote {
	@PersistenceContext(name="egovernment")
    EntityManager entityManager;
	@Override
	public Agent Authentification(String login, String pwd) {
		String requete="select e from Agent e where e.login=:l and e.pwd=:p";
		Agent agent=null;
		try{
		Query query = entityManager.createQuery(requete).setParameter("l", login).setParameter("p",pwd);
		
		agent = (Agent) query.getSingleResult();
		}catch(NoResultException ex){
		 System.out.println("no result found for query");
	}
		return agent;
		
		
	}

}
