package tn.esprit.services;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.ejb3.annotation.Clustered;

import tn.esprit.domain.Agent;


@Stateful
@Clustered
@Remote(AgentGestionRemote.class)

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
		System.out.println(agent.getLogin());
		return agent;
		}catch(NoResultException ex){
		 System.out.println("no result found for query");
	}
		return agent;
		
		
	}

}
