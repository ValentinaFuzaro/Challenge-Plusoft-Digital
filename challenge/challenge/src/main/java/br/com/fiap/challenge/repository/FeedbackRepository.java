package br.com.fiap.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.challenge.models.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long>{

}
