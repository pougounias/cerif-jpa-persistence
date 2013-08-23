package gr.ekt.cerif.services.link.result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.result.ResultPatent_Measurement;

@Component
public class LinkResultPatentMeasurementRepositoryImpl implements
		LinkResultPatentMeasurementRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkResultPatentMeasurementRepositoryImpl.class);
	
	@Autowired
	private LinkResultPatentMeasurementCrudRepository linkResultPatentMeasurementCrudRepository;

	@Override
	public void delete(ResultPatent_Measurement entity) {
		linkResultPatentMeasurementCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultPatent_Measurement> entities) {
		linkResultPatentMeasurementCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultPatent_Measurement> save(
			Iterable<ResultPatent_Measurement> entities) {
		return linkResultPatentMeasurementCrudRepository.save(entities);
	}

	@Override
	public ResultPatent_Measurement save(ResultPatent_Measurement entity) {
		return linkResultPatentMeasurementCrudRepository.save(entity);
	}

}
