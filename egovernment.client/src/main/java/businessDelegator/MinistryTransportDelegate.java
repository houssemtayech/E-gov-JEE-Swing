package businessDelegator;



import java.util.List;

import javax.el.StaticFieldELResolver;
import javax.swing.text.StyledEditorKit.BoldAction;

import serviceLocator.ServiceLocator;
import tn.esprit.domain.Bus;
import tn.esprit.domain.Request;
import tn.esprit.domain.transportMinistry;

import tn.esprit.services.TransportMinistryGestionRemote;

public class MinistryTransportDelegate {


	private static String jndi = "egovernment.ejb/TransportMinistryGestion!tn.esprit.services.TransportMinistryGestionRemote";

	public static TransportMinistryGestionRemote getProxy() {

		return (TransportMinistryGestionRemote) ServiceLocator.getInstance().getRemoteProxy(jndi);
	}

	public static boolean doReponseRequestsub(Request request) {
		return getProxy().ReponseRequestsub(request);

	}

	public static boolean ReponseRequestve(Request request) {
		return getProxy().ReponseRequestve(request);

	}

	public static List<Request> doviewrequestsub(String departement,int etat) {
		return getProxy().viewrequestsub( departement, etat);
	}

	public static List<Request> doviewrequestve() {
		return getProxy().viewrequestve();
	}
public static 	transportMinistry  doinformationcitzensub( int cin){
	return getProxy().informationcitzensub(cin);
	}

public  static transportMinistry informationcar( int cin){
	return getProxy().informationcar(cin);
	}
public  static  boolean doRequestDone( int id){
	return getProxy().RequestDone(id);
	}
public  static List<Bus> doViewBus() {
	return getProxy().ViewBus();
}
public  static Boolean doaddBus (Bus bus) {
	return getProxy().addBus(bus);
}
public static boolean doupdateBus(Bus bus) {
	return ( getProxy()).updateBus(bus);
}
public static  boolean doremoveBus(Bus bus) {
	return  getProxy().removeBus(bus);
}

public static Bus dofindlineBus(int id){
	return  getProxy().findlineBus(id);
	
}

}
