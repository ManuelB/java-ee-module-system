package de.incentergy.module.core;

import java.util.Map;

import javax.ejb.Remote;

@Remote
public interface RegistryRemote {
	public void add(String key, String value);
	public void remove(String key);
	public Map<String,String> entries();
}
