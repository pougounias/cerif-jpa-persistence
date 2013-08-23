package gr.ekt.cerif.services.link.project;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_ResultPublication;
import gr.ekt.cerif.entities.result.ResultPublication;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkProjectResultPublicationCrudRepository extends CrudRepository<Project_ResultPublication, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Project_ResultPublication> findByProject(Project project);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Project_ResultPublication> findByResultPublication(ResultPublication resultPublication);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = " select projrespub from ResultPublication respub "+
			"  left join respub.projects_resultPublications projrespub " +
			"  left join projrespub.project proj " +
			"  where respub.id = ?1 and proj.id= ?2 ")
	List<Project_ResultPublication> findByResPublIdAndProjectId(Long respubId, Long projId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = " select projrespub from Project_ResultPublication projrespub "+ 
			"  where projrespub.id = ?1 ")
	Project_ResultPublication findById(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = " select proj.id from ResultPublication respub "+
			"  left join respub.projects_resultPublications projrespub " +
			"  left join projrespub.theClass projrespubcl " +
			"  left join projrespub.project proj " +
			"  where respub.id = ?1 and projrespubcl.uri= ?2 ")
	List<Long> findProjectIdsByResPublIdAndClassUri(Long respubId, String classUri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = " select projrespub from ResultPublication respub "+
			"  left join respub.projects_resultPublications projrespub " +
			"  where respub.id = ?1 ")
	List<Project_ResultPublication> findByResPublId(Long respubId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = " select projrespub from ResultPublication respub "+
			"  left join respub.projects_resultPublications projrespub " +
			"  left join projrespub.theClass projrespubcl " +
			"  where respub.id = ?1 and projrespubcl.uri= ?2 ")
	List<Project_ResultPublication> findByResPublIdAndClassUri(Long respubId, String classUri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = " select projrespub from ResultPublication respub "+
			"  left join respub.projects_resultPublications projrespub " +
			"  left join projrespub.theClass projrespubcl " +
			"  left join projrespub.project proj " +
			"  where respub.id = ?1 and projrespubcl.uri= ?2 and proj.id= ?3 ")
	Project_ResultPublication findByResPublIdAndClassUriAndProjectId(Long respubId, String classUri, Long projId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select prrp from Project_ResultPublication prrp "+
		    "  join prrp.resultPublication rp "+
			"  join prrp.project pr "+
			"  where pr.id = ?1 and rp.id=?2 ")
	Project_ResultPublication findByProjectIdAndResultPublicationId(Long prId, Long resId);
		
}
