package businessDelegator;

import java.util.List;

import serviceLocator.ServiceLocator;
import tn.esprit.domain.Agent;

import tn.esprit.services.AgentGestionRemote;;


public class AgentServiceDelegate {
private static String jndiName="egovernment.ejb/AgentGestion!tn.esprit.services.AgentGestionRemote";
public static AgentGestionRemote getProxy()
{return   (AgentGestionRemote) ServiceLocator.getInstance().getRemoteProxy(jndiName);}
public static Agent Authentification(String login , String pwd){
	
	return getProxy().Authentification(login, pwd); 
};
}
