package tn.esprit.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.domain.Request;

@Local
public interface RequestGestionLocal {
	public List<Request> findRequestByDepartement(String departement);
	public List<Request> findRequestByType(String service);
	public Request findRequestById(int id);
	public Boolean RequestDone(int id);

}
