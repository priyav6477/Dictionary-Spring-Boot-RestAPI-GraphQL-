package com.dictionary.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dictionary.entity.Word;

public interface WordRepository extends JpaRepository<Word, Long>{
	List<Word> findByNameStartingWithIgnoreCase(String name);

	Optional<Word> findByNameIgnoreCase(String name);
}
