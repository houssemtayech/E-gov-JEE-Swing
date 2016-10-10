package businessDelegator;

import java.util.Date;

import serviceLocator.ServiceLocator;
import tn.esprit.domain.HightEducationMinistry;

import tn.esprit.services.EducationMinistryGestionRemote;

public class EducationMinistryGestionDelegator {
	
	private static String jndiName="egovernment.ejb/EducationMinistryGestion!"
			+ "tn.esprit.services.EducationMinistryGestionRemote";
	
public static EducationMinistryGestionRemote getProxy(){
		
		return (EducationMinistryGestionRemote) ServiceLocator.getInstance().getRemoteProxy(jndiName);
	}

public static Boolean addStudent(HightEducationMinistry student){
	return getProxy().addStudent(student);
}
public static Boolean addDiploma(HightEducationMinistry student, byte[] diploma){
	return getProxy().addDiploma(student, diploma);
}
public static byte[] findDiplomaByCin(int cin){
	return getProxy().findDiplomaByCin(cin);
}
public static HightEducationMinistry findStudentByCin(int cin){
	return getProxy().findStudentByCin(cin);
}
public static Boolean modifyStudent(HightEducationMinistry std) {
	return getProxy().modifyStudent(std);
	
}
public static boolean updateDiploma(HightEducationMinistry student){
	return getProxy().updateDiploma(student);
}
public static boolean deleteStudent(int cin){
	return getProxy().deleteStudent(cin);
	
	
}


public static  HightEducationMinistry  findStudentById(int id){
	 return getProxy().findStudentById(id);
}

public static  boolean updateStudent(int cin , String name, String lastname, String adress,String level,String establisement,Date date){
	
	return getProxy().updateStudent(cin, name, lastname, adress, level, establisement, date);
}

}


