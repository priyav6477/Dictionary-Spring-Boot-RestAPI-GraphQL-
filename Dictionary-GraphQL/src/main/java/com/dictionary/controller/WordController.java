package com.dictionary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.dictionary.entity.Word;
import com.dictionary.service.WordService;

@Controller
public class WordController {
	@Autowired
	private WordService wordService;

	@MutationMapping
	public Word saveWord(@Argument Word word) {
		return wordService.saveWord(word);
	}

	@QueryMapping
	public List<Word> getWordsByIndex(@Argument String name) {
		return wordService.getWordsByIndex(name);

	}

	@QueryMapping
	public Word getWordByName(@Argument String name) {
		return wordService.getWordByName(name);
	}

	@MutationMapping
	public Word updateWord(@Argument Long id,@Argument Word word) {
		return wordService.updateWord(id, word);
	}

	@MutationMapping
	public boolean deleteWord(@Argument Long id) {
		return wordService.deleteWord(id);
	}
}
