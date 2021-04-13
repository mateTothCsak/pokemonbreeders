package net.tcsm.pokemonbreeders.mapper;
import net.tcsm.pokemonbreeders.dto.PokemonEggGroup;
import net.tcsm.pokemonbreeders.model.PokemonEggGroupEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PokemonEggGroupMapper {

    PokemonEggGroupMapper pokemonEggGroupMapper = Mappers.getMapper(PokemonEggGroupMapper.class);

    PokemonEggGroup toDto(PokemonEggGroupEntity entity);

    PokemonEggGroupEntity toEntity(PokemonEggGroup dto);

}
