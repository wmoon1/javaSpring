package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
	@Query(value = "SELECT * FROM participant where partId=?1", nativeQuery = true)
    List<Participant> findParticipant(int custId);
}
