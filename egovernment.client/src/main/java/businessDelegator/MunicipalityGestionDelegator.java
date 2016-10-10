package businessDelegator;

import java.util.Date;

import serviceLocator.ServiceLocator;
import tn.esprit.domain.Man;
import tn.esprit.domain.Municipality;
import tn.esprit.domain.Woman;

import tn.esprit.services.MunicipalityGestionRemote;

public class MunicipalityGestionDelegator {

	private static String jndiName="egovernment.ejb/MunicipalityGestion!"
			+"tn.esprit.services.MunicipalityGestionRemote";
	
public static MunicipalityGestionRemote getProxy(){
		
		return (MunicipalityGestionRemote) ServiceLocator.getInstance().getRemoteProxy(jndiName);
	}

public static Municipality birthCertificateByCin(int cin){
	
	return getProxy().birthCertificateByCin(cin);
}
public static Municipality birthCertificateByName(String fname, String lname, Date birthDate, String place){
	
	return getProxy().birthCertificateByName(fname, lname, birthDate, place);
}
public static Municipality deathCertificateByCin(int cin){
	
	return getProxy().deathCertificateByCin(cin);
}

public static Municipality deathCertificateByName(String fname, String lname, Date deathDate){

	return getProxy().deathCertificateByName(fname, lname, deathDate);
}
public static String weddingCertificateGenderByCin(int cin){
	
	return getProxy().weddingCertificateGenderByCin(cin);
}
public static Boolean  addWeddingCertificate(int cin1, int cin2, Date weddingDate){
	
	return getProxy().addWeddingCertificate(cin1, cin2, weddingDate);
}
public static Man weddingCertificateMan(int cin){
	
	return getProxy().weddingCertificateMan(cin);
}
public static Woman weddingCertificateWoman(int cin){
	
	return getProxy().weddingCertificateWoman(cin);
}
public static Boolean babyRedistration(Municipality baby){
	
	return getProxy().babyRedistration(baby);
}
public static Boolean DeathRegistration(int cin, Date date){
	
	return getProxy().DeathRegistration(cin, date);
}
public static Boolean DeathRegistrationByName(Date date, String fname, String lname, Date birthDate, String birthPlace){
	
	return getProxy().DeathRegistrationByName(date,fname,lname,birthDate,birthPlace);
}
}
