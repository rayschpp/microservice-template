/**
 * 
 */
package ${package}.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ${package}.exception.${entity}NotFoundException;
import ${package}.model.${entity};
import ${package}.repository.${entity}Repository;

/**
 * @author raynhold
 *
 */
@Service
public class ${entity}Service implements I${entity}Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(${entity}Service.class);

    private final ${entity}Repository repository;

    /**
     * @param repository
     */
    public ${entity}Service(${entity}Repository repository) {
	super();
	this.repository = repository;
    }

    @Override
    public List<${entity}> getAll() {
	LOGGER.debug("Return all $entity.toLowerCase()s");
	return this.repository.findAll().stream() //
		.collect(Collectors.toList());
    }

    @Override
    public ${entity} createNew${entity}(${entity} new${entity}) {
	LOGGER.debug("Created new: " + new${entity}.toString());
	return this.repository.save(new${entity});
    }

    @Override
    public ${entity} findById(Long id) {
	${entity} entity = this.repository //
		.findById(id) //
		.orElseThrow(() -> new ${entity}NotFoundException(id));
	LOGGER.debug("Found: " + entity.toString());
	return entity;
    }

    @Override
    public void deleteById(Long id) {
	LOGGER.debug("Delete $entity.toLowerCase() with id: " + id);
	this.repository.deleteById(id);
    }

    @Override
    public ${entity} update${entity}(Long id, ${entity} new${entity}) {
	LOGGER.debug("Updated $entity.toLowerCase(): " + id + "with: " + new${entity});
	return this.repository.findById(id) //
		.map(entity -> {
		    entity.setName(new${entity}.getName());
		    entity.setDescription(new${entity}.getDescription());
		    entity.setUnspsc(new${entity}.getUnspsc());
		    return this.repository.save(entity);
		}) //
		.orElseGet(() -> {
		    return this.repository.save(new${entity});
		});
    }
}
