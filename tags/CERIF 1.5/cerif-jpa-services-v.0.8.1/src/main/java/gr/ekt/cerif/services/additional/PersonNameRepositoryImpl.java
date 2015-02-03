package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.PersonName_Class;
import gr.ekt.cerif.entities.link.PersonName_Person;
import gr.ekt.cerif.features.additional.PersonName;
import gr.ekt.cerif.services.link.personname.LinkPersonNameClassRepository;
import gr.ekt.cerif.services.link.personname.LinkPersonNamePersonRepository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class PersonNameRepositoryImpl implements PersonNameRepository {
	
	private static final Logger log = LoggerFactory.getLogger(PersonNameRepositoryImpl.class);
	
	@Autowired
	private PersonNameCrudRepository personNameCrudRepository;
	
	@Autowired
	private LinkPersonNamePersonRepository linkPersonNamePersonRepository;
	
	@Autowired
	private LinkPersonNameClassRepository linkPersonNameClassRepository;

	
	@Override
	public void delete(PersonName entity) {
		List<PersonName_Person> pnp = linkPersonNamePersonRepository.findByPersonName(entity);
		if (pnp != null) linkPersonNamePersonRepository.delete(pnp);
		entity.setPersonNames_persons(null);
		
		List<PersonName_Class> pnc = linkPersonNameClassRepository.findByPersonName(entity);
		if (pnc != null) linkPersonNameClassRepository.delete(pnc);
		entity.setPersonNames_classes(null);
		
		personNameCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<PersonName> entities) {
		personNameCrudRepository.delete(entities);
	}

	@Override
	public Iterable<PersonName> save(Iterable<PersonName> entities) {
		return personNameCrudRepository.save(entities);
	}

	@Override
	public PersonName save(PersonName entity) {
		return personNameCrudRepository.save(entity);
	}

	@Override
	public List<PersonName> findAll() {
		return personNameCrudRepository.findAll();
	}

	@Override
	public Page<PersonName> findAll(Pageable page) {
		return personNameCrudRepository.findAll(page);
	}

	@Override
	public PersonName findById(Long id) {
		return personNameCrudRepository.findById(id);
	}

	@Override
	public List<PersonName> findAllNamesByPersonId(Long id) {
		return personNameCrudRepository.findAllNamesByPersonId(id);
	}

	@Override
	public List<PersonName> findByPerson(Person person) {
		return personNameCrudRepository.findByPerson(person);
	}

}
