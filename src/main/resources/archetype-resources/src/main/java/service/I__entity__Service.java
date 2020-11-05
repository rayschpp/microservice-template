package ${package}.service;

import java.util.List;

import ${package}.model.${entity};

public interface I${entity}Service {

	List<${entity}> getAll();

	${entity} createNew${entity}(${entity} new${entity});

	${entity} findById(Long id);
	
	void deleteById(Long id);
	
	${entity} update${entity}(Long id, ${entity} new${entity});

}