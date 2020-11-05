/**
 * 
 */
package ${package}.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import ${package}.controller.${entity}Controller;
import ${package}.model.${entity};

/**
 * @author raynhold
 *
 */
@Component
public class ${entity}ModelAssembler implements RepresentationModelAssembler<${entity}, EntityModel<${entity}>> {

	private static final Logger LOGGER = LoggerFactory.getLogger(${entity}ModelAssembler.class);

	private static String getResourceName(Class clazz) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(clazz.getSimpleName().toLowerCase());
		stringBuilder.append('s');
		return stringBuilder.toString();
	}
	
	@Override
	public EntityModel<${entity}> toModel(${entity} entity) {
		return EntityModel.of(entity, //
				linkTo(methodOn(${entity}Controller.class).one(entity.getId())).withSelfRel(),
				linkTo(methodOn(${entity}Controller.class).all()).withRel(getResourceName(${entity}.class)));
	}

	@Override
	public CollectionModel<EntityModel<${entity}>> toCollectionModel(Iterable<? extends ${entity}> entities) {
		return CollectionModel.of( //
				StreamSupport.stream(entities.spliterator(), false) //
						.map(this::toModel) //
						.collect(Collectors.toList()),
				linkTo(methodOn(${entity}Controller.class).all()).withSelfRel());
	}

}
