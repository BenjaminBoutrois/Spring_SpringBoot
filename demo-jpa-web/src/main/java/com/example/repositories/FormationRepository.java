package com.example.repositories;

import java.util.List;

import com.example.entities.Formation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FormationRepository extends JpaRepository<Formation, Long>
{
	List<Formation> findByTheme(String theme);
}
