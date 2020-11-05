/**
 * 
 */
package ${package}.exception;

/**
 * @author raynhold
 *
 */
public class ${entity}NotFoundException extends RuntimeException {

	public ${entity}NotFoundException(Long id) {
		super("Could not find $entity.toLowerCase() " + id);
	}
}
