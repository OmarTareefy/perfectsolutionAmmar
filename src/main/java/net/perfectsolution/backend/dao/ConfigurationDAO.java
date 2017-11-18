package net.perfectsolution.backend.dao;

import net.perfectsolution.backend.dto.Configuration;

public interface ConfigurationDAO {
	Configuration get(int id);
	boolean update(Configuration configuration);
}
