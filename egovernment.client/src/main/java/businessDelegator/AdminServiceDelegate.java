package businessDelegator;

import java.util.List;

import javax.persistence.Query;

import serviceLocator.ServiceLocator;
import tn.esprit.domain.Agent;
import tn.esprit.domain.Reclamation;
import tn.esprit.services.AdminGestionRemote;
import tn.esprit.services.AgentGestionRemote;

public class AdminServiceDelegate {
	private static String jndiName="egovernment.ejb/AdminGestion!tn.esprit.services.AdminGestionRemote";
	public static AdminGestionRemote getProxy()
	{return   (AdminGestionRemote) ServiceLocator.getInstance().getRemoteProxy(jndiName);}
	
	
	 public static List<Reclamation> findReclamationByType(){
			
			return getProxy().findReclamationByType();}

     public static boolean deleteClaim(int id){
    	 
    	 return getProxy().deleteClaim(id);
     }
     public static List<Agent> findAgent() {
 		return getProxy().findAgent();
 	}
     public static boolean deleteAgent(int id){
    	 return getProxy().deleteAgent(id);
     }
	 public static boolean updateAgent(int id, String login, String pwd, String role){
		 return getProxy().updateAgent( id,  login,  pwd,  role);
		 
	 }
	  public static boolean addAgent(Agent agent){
		  
		  return getProxy().addAgent(agent);
	  }
	  public static List<Agent> findAgentByRole(String role)
	  {
		  return getProxy().findAgentByRole(role);
	  }
}
