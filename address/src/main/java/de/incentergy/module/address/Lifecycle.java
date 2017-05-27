package de.incentergy.module.address;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import de.incentergy.module.core.RegistryRemote;

@Singleton
@Startup
public class Lifecycle {
	
	private static final Logger log = Logger.getLogger(Lifecycle.class.getName());
	
	@EJB(lookup="java:global/core/Registry!de.incentergy.module.core.RegistryRemote")
	RegistryRemote registry;
	
	@PostConstruct
	public void init() {
		registry.add("AddressModuleStatus", "INSTALLED");
		log.info("Installed");
	}
	
	@PreDestroy
	public void destroy() {
		registry.remove("AddressModuleStatus");
		log.info("Remove");
	}
}
