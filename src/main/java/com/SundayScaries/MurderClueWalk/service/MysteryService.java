package com.SundayScaries.MurderClueWalk.service;

import com.SundayScaries.MurderClueWalk.domain.Mystery;
import com.SundayScaries.MurderClueWalk.repository.MysteryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MysteryService {

    static MysteryRepository mysteryRepository;

    public MysteryService(MysteryRepository mysteryRepository) {
        this.mysteryRepository = mysteryRepository;
    }


    public List<Mystery> findAll() {
        return mysteryRepository.findAll();
    }

    public Optional<Mystery> findById(Long id) {
        return mysteryRepository.findById(id);
    }

    public static Mystery save(Mystery mystery) {
        mysteryRepository.save(mystery);
        return mystery;
    }


    public void deleteById(Long id) {
        mysteryRepository.deleteById(id);

    }


    public Mystery findByMysteryName(String mysteryName) {
        Optional<Mystery> optionalMystery = mysteryRepository.findByMysteryName(mysteryName);
        if (optionalMystery.isPresent()) {
            return optionalMystery.get();
        }
        return null;
    }


}
