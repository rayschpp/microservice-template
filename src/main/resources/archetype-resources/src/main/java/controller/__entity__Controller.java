/**
 * 
 */
package ${package}.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ${package}.assembler.${entity}ModelAssembler;
import ${package}.model.$entity;
import ${package}.service.I${entity}Service;

/**
 * @author raynhold
 *
 */
@RestController
public class ${entity}Controller {

	private static final Logger LOGGER = LoggerFactory.getLogger(${entity}Controller.class);

	private final I${entity}Service service;
	private final ${entity}ModelAssembler assembler;

	public ${entity}Controller(I${entity}Service service, ${entity}ModelAssembler assembler) {
		super();
		this.service = service;
		this.assembler = assembler;
	}

	@GetMapping("/$entity.toLowerCase()s")
	public CollectionModel<EntityModel<$entity>> all() {
		LOGGER.debug("Request for $entity.toLowerCase()s");
		return this.assembler.toCollectionModel(this.service.getAll());
	}

	@PostMapping("/$entity.toLowerCase()s")
	public ResponseEntity<?> new${entity}(@RequestBody $entity new${entity}) {
		LOGGER.debug("Request new $entity.toLowerCase()");
		EntityModel<$entity> entityModel = this.assembler.toModel(this.service.createNew${entity}(new${entity}));
		return ResponseEntity //
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

	@GetMapping("/$entity.toLowerCase()s/{id}")
	public EntityModel<$entity> one(@PathVariable Long id) {
		LOGGER.debug("Request for $entity.toLowerCase() with id: " + id);
		return this.assembler.toModel(this.service.findById(id));
	}

	@PutMapping("/$entity.toLowerCase()s/{id}")
	public ResponseEntity<?> replace${entity}(@PathVariable Long id, @RequestBody $entity new${entity}) {
		LOGGER.debug("Request for $entity.toLowerCase() update");
		EntityModel<$entity> entityModel = this.assembler.toModel(this.service.update${entity}(id, new${entity}));
		return ResponseEntity //
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

	@DeleteMapping("/$entity.toLowerCase()s/{id}")
	public ResponseEntity<?> delete${entity}(@PathVariable Long id) {
		LOGGER.debug("Request to delete $entity.toLowerCase()");
		this.service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
