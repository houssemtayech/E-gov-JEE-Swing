package businessDelegator;

import java.sql.Date;
import java.util.List;

import serviceLocator.ServiceLocator;
import tn.esprit.domain.InteriorMinistry;
import tn.esprit.domain.Reclamation;

import tn.esprit.services.InteriorMinistryGestionRemote;

public class InteriorMinistryGestionDelegator {
	
	private static String jndiName="egovernment.ejb/InteriorMinistryGestion!tn.esprit.services.InteriorMinistryGestionRemote";
	
public static InteriorMinistryGestionRemote getProxy(){
		
		return (InteriorMinistryGestionRemote) ServiceLocator.getInstance().getRemoteProxy(jndiName);
	}

public static Boolean addPerson(InteriorMinistry person){
	return getProxy().addPerson(person);
}

public static Boolean modifyPerson(InteriorMinistry person){
	return getProxy().modifyPerson(person);
}

public static InteriorMinistry findPersonByCin(int cin){
	return getProxy().findPersonByCin(cin);
}

public static InteriorMinistry findPersonByName(String fname, String lname, Date birthDte, String birthPlace){
	return getProxy().findPersonByName(fname, lname, birthDte, birthPlace);
}

	
}
