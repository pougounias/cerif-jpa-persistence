/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.second.ElectronicAddress;

/**
 * @author bonisv
 *
 */
public interface ElectronicAddressRepository {
	
	ElectronicAddress findByUri(String uri);
	
	ElectronicAddress findByOrganisationUnit(OrganisationUnit organisationUnit);

	public void delete(ElectronicAddress entity); 
	
	public void delete(Iterable<ElectronicAddress> entities); 

	public Iterable<ElectronicAddress> save(Iterable<ElectronicAddress> entities); 
	
	public ElectronicAddress save(ElectronicAddress entity);

}
