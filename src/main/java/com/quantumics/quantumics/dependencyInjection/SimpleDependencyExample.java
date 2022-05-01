package com.quantumics.quantumics.dependencyInjection;

import com.quantumics.quantumics.dependencyInjection.client.Client;
import com.quantumics.quantumics.dependencyInjection.client.ClientA;
import com.quantumics.quantumics.dependencyInjection.service.Service;
import com.quantumics.quantumics.dependencyInjection.service.ServiceB;
import com.quantumics.quantumics.dependencyInjection.service.ServiceC;

public class SimpleDependencyExample {

	public static void main(String[] args) {

		Service service = new ServiceB();
		Client client = new ClientA(service);
		client.doSomething();
		((ClientA) client).setService(new ServiceC());
		
		client.doSomething();
	}

}
