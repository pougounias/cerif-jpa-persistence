package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Indicator;

/**
 * A repository for links between organisations and indicators.
 * 
 */
public interface LinkOrganisationUnitIndicatorRepository {
	
	public void delete(OrganisationUnit_Indicator entity); 
	
	public void delete(Iterable<OrganisationUnit_Indicator> entities); 

	public Iterable<OrganisationUnit_Indicator> save(Iterable<OrganisationUnit_Indicator> entities); 
	
	public OrganisationUnit_Indicator save(OrganisationUnit_Indicator entity);

}
