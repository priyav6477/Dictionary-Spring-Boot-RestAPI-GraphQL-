package com.dictionary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dictionary.entity.Word;
import com.dictionary.service.WordService;

@RestController
@RequestMapping("/dictionary")
public class WordController {
	@Autowired
	private WordService wordService;

	@PostMapping("/save")
	public Word saveWord(@RequestBody Word word) {
		return wordService.saveWord(word);
	}

	@GetMapping("/list/{index}")
	public List<Word> getWordsByIndex(@PathVariable String index) {
		return wordService.getWordsByIndex(index);

	}

	@GetMapping("/definition/{name}")
	public Word getDefinitionAndUsages(@PathVariable String name) {
		return wordService.getWordByName(name);
	}

	@PutMapping("/update/{id}")
	public Word updateWord(@PathVariable Long id, @RequestBody Word updatedWord) {
		return wordService.updateWord(id, updatedWord);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteWord(@PathVariable Long id) {
		return wordService.deleteWord(id);
	}
}
