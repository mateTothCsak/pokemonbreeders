package net.tcsm.pokemonbreeders.service;

import net.tcsm.pokemonbreeders.repository.EggGroupProseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EggGroupProseSerivce {

    private static final Long englishLanguageID = 9L;

    @Autowired
    private EggGroupProseRepository repository;

    public String getEnglishName(Long eggGroupID) {
        return repository.findByEggGroupIDAndLocalLanguageID(eggGroupID, englishLanguageID).getName();
    }

    public Long getEggGroupIDByEnglishName(String englishName){
        return repository.findByNameAndLocalLanguageID(englishName, englishLanguageID).getEggGroupID();
    };
}
