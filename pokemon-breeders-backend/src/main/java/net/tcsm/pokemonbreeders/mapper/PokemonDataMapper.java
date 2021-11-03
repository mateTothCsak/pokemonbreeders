package net.tcsm.pokemonbreeders.mapper;
import net.tcsm.pokemonbreeders.dto.PokemonData;
import net.tcsm.pokemonbreeders.model.PokemonDataEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PokemonDataMapper {

    PokemonDataMapper pokemonDataMapper = Mappers.getMapper(PokemonDataMapper.class);

    PokemonData toDto(PokemonDataEntity entity);
    PokemonDataEntity toEntity(PokemonData dto);

}
