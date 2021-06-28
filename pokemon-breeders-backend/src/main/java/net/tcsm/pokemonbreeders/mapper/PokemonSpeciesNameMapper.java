package net.tcsm.pokemonbreeders.mapper;
import net.tcsm.pokemonbreeders.dto.PokemonEggGroup;
import net.tcsm.pokemonbreeders.dto.PokemonSpeciesName;
import net.tcsm.pokemonbreeders.model.PokemonEggGroupEntity;
import net.tcsm.pokemonbreeders.model.PokemonSpeciesNameEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PokemonSpeciesNameMapper {

    PokemonSpeciesNameMapper pokemonSpeciesNameMapper = Mappers.getMapper(PokemonSpeciesNameMapper.class);

    PokemonSpeciesName toDto(PokemonSpeciesNameEntity entity);
    PokemonSpeciesNameEntity toEntity(PokemonSpeciesName dto);

}
