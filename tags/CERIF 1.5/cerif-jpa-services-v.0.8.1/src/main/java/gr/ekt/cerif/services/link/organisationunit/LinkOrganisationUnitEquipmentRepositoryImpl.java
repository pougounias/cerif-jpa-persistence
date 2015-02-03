package gr.ekt.cerif.services.link.organisationunit;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Equipment;

@Component
public class LinkOrganisationUnitEquipmentRepositoryImpl implements
		LinkOrganisationUnitEquipmentRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkOrganisationUnitEquipmentRepositoryImpl.class);
	
	@Autowired
	private LinkOrganisationUnitEquipmentCrudRepository linkOrganisationUnitEquipmentCrudRepository;

	@Override
	public void delete(OrganisationUnit_Equipment entity) {
		linkOrganisationUnitEquipmentCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<OrganisationUnit_Equipment> entities) {
		linkOrganisationUnitEquipmentCrudRepository.delete(entities);
	}

	@Override
	public Iterable<OrganisationUnit_Equipment> save(
			Iterable<OrganisationUnit_Equipment> entities) {
		return linkOrganisationUnitEquipmentCrudRepository.save(entities);
	}

	@Override
	public OrganisationUnit_Equipment save(OrganisationUnit_Equipment entity) {
		return linkOrganisationUnitEquipmentCrudRepository.save(entity);
	}

	@Override
	public List<OrganisationUnit_Equipment> findByOrganisationUnit(
			OrganisationUnit organisationUnit) {
		return linkOrganisationUnitEquipmentCrudRepository.findByOrganisationUnit(organisationUnit);
	}

	@Override
	public List<OrganisationUnit_Equipment> findByEquipment(Equipment equipment) {
		return linkOrganisationUnitEquipmentCrudRepository.findByEquipment(equipment);
	}

}
