package tn.esprit.tests;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.services.CounterServiceRemote;





public class CounterTest {

	public static void main(String[] args) {
		CounterServiceRemote counterServiceRemote = lookupRemoteEJB();
		int s = counterServiceRemote.doIncrementCounter();
		System.out.println("Counter = " + s);
		s = counterServiceRemote.doIncrementCounter();
		System.out.println("Counter = " + s);
		pause();
		s = counterServiceRemote.doIncrementCounter();
		System.out.println("Counter = " + s);
	}

	private static CounterServiceRemote lookupRemoteEJB() {
		CounterServiceRemote counterServiceRemote = null;
		Context ctx;
		try {
			ctx = new InitialContext();
			counterServiceRemote = (CounterServiceRemote) ctx
					.lookup("/egovernment.ejb/RequestGestion!tn.esprit.services.CounterServiceRemote");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return counterServiceRemote;
	}

	public static void pause() {
		InputStreamReader istream = null;
		BufferedReader bufRead = null;
		istream = new InputStreamReader(System.in);
		bufRead = new BufferedReader(istream);
		String returnval = null;
		try {
			returnval = bufRead.readLine();
			bufRead.close();
			istream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
