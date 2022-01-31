package com.travelExpress.covoiturage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.travelExpress.covoiturage.models.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Integer> {
}
