package businessDelegator;

import serviceLocator.ServiceLocator;
import tn.esprit.domain.Poste;
import tn.esprit.services.PostGestionRemote;



public class PostGestionDelegator {
	
	public static String jndiName="egovernment.ejb/PostGestion!tn.esprit.services.PostGestionRemote";
	

public static PostGestionRemote getProxy(){
		
		return (PostGestionRemote) ServiceLocator.getInstance().getRemoteProxy(jndiName);
	}

public static Boolean addReceipt(Poste receipt)
{
	return getProxy().addReceipt(receipt);
}
public static boolean deleteReceipt(int id){
	return getProxy().deleteReceipt(id);
	
}
public static Poste findReceiptByCin(int cin)
{
	return getProxy().findReceiptByCin(cin);
}

}
