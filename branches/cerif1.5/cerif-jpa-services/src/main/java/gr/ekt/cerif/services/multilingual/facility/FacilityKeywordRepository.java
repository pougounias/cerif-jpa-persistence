/**
 * 
 */
package gr.ekt.cerif.services.multilingual.facility;

import gr.ekt.cerif.features.multilingual.FacilityKeyword;

/**
 * @author bonisv
 *
 */
public interface FacilityKeywordRepository {

	public void delete(FacilityKeyword entity); 
	
	public void delete(Iterable<FacilityKeyword> entities); 

	public Iterable<FacilityKeyword> save(Iterable<FacilityKeyword> entities); 
	
	public FacilityKeyword save(FacilityKeyword entity);
}
