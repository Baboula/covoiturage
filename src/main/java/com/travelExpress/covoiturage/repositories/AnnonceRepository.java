package com.travelExpress.covoiturage.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travelExpress.covoiturage.models.Annonce;


@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, Integer> {
	
	
	public List<Annonce> findByLieuDepart(String lieuDepart);
	
	  @Query(value="select * from annonce a where a.conducteur_id_compte= :x ", nativeQuery = true)
	  public List<Annonce> findByConducteur(@Param("x")Integer id);
	
	  @Query(value="select * from annonce  where annonce.lieu_depart like %:ld% AND annonce.lieu_arriver like %:la% order by annonce.date_depart desc", nativeQuery = true) 
	  public List<Annonce> findBylieux(@Param("ld")String ld,@Param("la")String la);
	  
	  @Query(value="select a from annonce a where a.compte.conducteur_id_compte= :x order by a.dateheure_depart ", nativeQuery = true
	  ) public Page<Object[]> listannonce(@Param("x")Integer idConducteur,Pageable
	  pageable);
	 
}
