package com.dictionary.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dictionary.entity.Word;
import com.dictionary.exception.WordAlreadyExistsException;
import com.dictionary.exception.WordNotFoundException;
import com.dictionary.repository.WordRepository;

@Service
public class WordService {

	@Autowired
	private WordRepository wordRepository;

	public Word saveWord(Word word) {
		// Check if the word already exists
		Optional<Word> existingWord = wordRepository.findByNameIgnoreCase(word.getName());
		if (existingWord.isPresent()) {
			throw new WordAlreadyExistsException("Word '" + word.getName() + "' already exists in the dictionary.");
		}
		return wordRepository.save(word);
	}

	public List<Word> getWordsByIndex(String index) {
		List<Word> words = wordRepository.findByNameStartingWithIgnoreCase(index);
		if (words.size() <= 0) {
			throw new WordNotFoundException("Words not found with index '" + index + "' in the dictionary");
		}
		return words;
	}

	public Word getWordByName(String name) {
		Optional<Word> existingWord = wordRepository.findByNameIgnoreCase(name);
		if (!existingWord.isPresent()) {
			throw new WordNotFoundException("Word with name '" + name + "' not found.");
		}
		return existingWord.get();
	}

	public Word updateWord(Long id, Word updatedWord) {
		Word existingWord = wordRepository.findById(id)
				.orElseThrow(() -> new WordNotFoundException("Word with id '" + id + "' not found."));

		// Update the fields
		existingWord.setName(updatedWord.getName());
		existingWord.setDefinition(updatedWord.getDefinition());
		existingWord.setWordUsage(updatedWord.getWordUsage());
		return wordRepository.save(existingWord);
	}

	public boolean deleteWord(Long id) {
		if (!wordRepository.existsById(id)) {
			throw new WordNotFoundException("Word with id '" + id + "' not found.");
		}
		wordRepository.deleteById(id);
		return true;
	}

}
