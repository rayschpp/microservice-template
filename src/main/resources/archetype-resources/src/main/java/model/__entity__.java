/**
 * 
 */
package ${package}.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author raynhold
 *
 */
@Entity
public class $entity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int unspsc;
	private String name;
	private String description;
	
	public ${entity}() {super();}
	
	/**
	 * @param id
	 * @param unspsc
	 * @param name
	 * @param description
	 */
	public ${entity}(long id, int unspsc, String name, String description) {
		super();
		setId(id);
		setUnspsc(unspsc);
		setName(name);
		setDescription(description);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getUnspsc() {
		return unspsc;
	}

	public void setUnspsc(int unspsc) {
		this.unspsc = unspsc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getDescription(), getId(), getName(), getUnspsc());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		$entity other = ($entity) obj;
		return Objects.equals(getDescription(), other.getDescription()) && getId() == other.getId() && Objects.equals(getName(), other.getName())
				&& getUnspsc() == other.getUnspsc();
	}

	@Override
	public String toString() {
		return "$entity [id=" + id + ", unspsc=" + unspsc + ", name=" + name + ", description=" + description + "]";
	}
}
