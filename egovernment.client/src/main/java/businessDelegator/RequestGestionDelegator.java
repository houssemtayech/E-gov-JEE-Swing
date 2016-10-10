package businessDelegator;

import java.util.List;

import serviceLocator.ServiceLocator;
import tn.esprit.domain.Request;

import tn.esprit.services.RequestGestionRemote;

public class RequestGestionDelegator {
	public static String jndiName = "egovernment.ejb/RequestGestion!tn.esprit.services.RequestGestionRemote";

	public static RequestGestionRemote getProxy() {

		return (RequestGestionRemote) ServiceLocator.getInstance().getRemoteProxy(jndiName);
	}

	public static List<Request> findRequestByDepartement(String departement) {
		return getProxy().findRequestByDepartement(departement);
	}

	public static List<Request> findRequestByType(String service) {
		return getProxy().findRequestByType(service);
	}

	public static Request findRequestById(int id) {
		return getProxy().findRequestById(id);
	}

	public static Boolean RequestDone(int id) {
		return getProxy().RequestDone(id);
	}
}
