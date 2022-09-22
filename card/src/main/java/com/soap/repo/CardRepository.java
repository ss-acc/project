package com.soap.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soap.entities.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long>{


	Card findByCardno(long cardno);

}
