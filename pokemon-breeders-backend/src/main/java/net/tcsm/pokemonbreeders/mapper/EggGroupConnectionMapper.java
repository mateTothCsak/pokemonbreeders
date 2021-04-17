package net.tcsm.pokemonbreeders.mapper;
import net.tcsm.pokemonbreeders.dto.EggGroupConnection;
import net.tcsm.pokemonbreeders.model.EggGroupConnectionEntity;
import net.tcsm.pokemonbreeders.model.PokemonEggGroupEntity;
import net.tcsm.pokemonbreeders.util.EggGroupConnector;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EggGroupConnectionMapper {

    EggGroupConnectionMapper eggGroupConnectionMapper = Mappers.getMapper(EggGroupConnectionMapper.class);

    List<EggGroupConnection> toDtoList(List<EggGroupConnectionEntity> entity);

}
