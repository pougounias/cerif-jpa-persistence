/**
 * 
 */
package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.link.project.Project_Facility;

/**
 * A repository for links between projects and Facilities.
 * 
 */
public interface LinkProjectFacilityRepository {

	public void delete(Project_Facility entity); 
	
	public void delete(Iterable<Project_Facility> entities); 

	public Iterable<Project_Facility> save(Iterable<Project_Facility> entities); 
	
	public Project_Facility save(Project_Facility entity);
	
}
