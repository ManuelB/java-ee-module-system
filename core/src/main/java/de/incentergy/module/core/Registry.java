package de.incentergy.module.core;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Singleton
@Path("/registry")
public class Registry implements RegistryRemote {

	private Map<String, String> map = new HashMap<>();

	@Override
	public void add(String key, String value) {
		map.put(key, value);
	}

	@Override
	public void remove(String key) {
		map.remove(key);

	}

	@Override
	@GET
	@Path("/entries")
	public Map<String, String> entries() {
		return map;
	}

}
