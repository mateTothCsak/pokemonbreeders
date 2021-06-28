package net.tcsm.pokemonbreeders.mapper;
import net.tcsm.pokemonbreeders.dto.EggGroupProse;
import net.tcsm.pokemonbreeders.model.EggGroupProseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EggGroupProseMapper {

    EggGroupProseMapper eggGroupProseMapper = Mappers.getMapper(EggGroupProseMapper.class);

    EggGroupProse toDto(EggGroupProseEntity entity);
    EggGroupProseEntity toEntity(EggGroupProse dto);

}
