package businessDelegator;

import java.util.List;

import serviceLocator.ServiceLocator;
import tn.esprit.domain.Reclamation;

import tn.esprit.services.ClaimGestionRemote;

public class ClaimGestionDelegator {
	
	
	
private static String jndiName="egovernment.ejb/ClaimGestion!tn.esprit.services.ClaimGestionRemote";
	
public static ClaimGestionRemote getProxy(){
		
		return (ClaimGestionRemote) ServiceLocator.getInstance().getRemoteProxy(jndiName);
	}

public static boolean addClaim(Reclamation rec){
	
	return getProxy().addClaim(rec);
}
public static boolean deleteClaim(int id){
	return getProxy().deleteClaim(id);
	
}
public static List<Reclamation> findReclamationByType(String type){
	
	return getProxy().findReclamationByType(type);
}
public static Reclamation findClaimById(int id) {
	return getProxy().findClaimById(id);
	
}


}


