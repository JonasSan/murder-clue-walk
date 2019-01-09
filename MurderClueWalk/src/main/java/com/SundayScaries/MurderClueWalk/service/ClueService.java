package com.SundayScaries.MurderClueWalk.service;

import com.SundayScaries.MurderClueWalk.domain.Clue;
import com.SundayScaries.MurderClueWalk.repository.ClueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClueService {

    static ClueRepository clueRepository;

    public ClueService(ClueRepository clueRepository) {
        this.clueRepository = clueRepository;
    }


    public List<Clue> findAll() {
        return clueRepository.findAll();
    }

    public Optional<Clue> findById(Long id) {
        return clueRepository.findById(id);
    }

    public static Clue save(Clue clue) {
        clueRepository.save(clue);
        return clue;
    }


    public void deleteById(Long id) {
        clueRepository.deleteById(id);

    }


    public Clue findByClueText(String clueText) {
        Optional<Clue> optionalClue = clueRepository.findByClueText(clueText);
        if (optionalClue.isPresent()) {
            return optionalClue.get();
        }
        return null;
    }


}
