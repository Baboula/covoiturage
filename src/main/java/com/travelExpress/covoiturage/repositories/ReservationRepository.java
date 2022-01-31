package com.travelExpress.covoiturage.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.travelExpress.covoiturage.models.Reservation;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
	
	@Query(value="select * from reservation where reservation.annonce_id = :id ",nativeQuery = true )
	public List<Reservation> findByIdannonce(@Param("id")Integer id);
}
