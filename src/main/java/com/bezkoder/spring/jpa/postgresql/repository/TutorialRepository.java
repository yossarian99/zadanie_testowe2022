package com.james.spring.jpa.postgresql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.james.spring.jpa.postgresql.model.Kolumns;

public interface TutorialRepository extends JpaRepository<Kolumns, Long> {
//  List<kolumns> findByPublished(boolean published);

//  List<kolumns> findByTitleContaining(List<kolumns> kolumns);

//  List<Kolumns> findByPublished(boolean published) ;

  List<Kolumns> findByKolumnsContaining(String kolumna1);
}
