package ma.xproce.inventoryservice.service;

import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dao.repositories.CreatorRepository;
import ma.xproce.inventoryservice.dtos.CreatorDto;
import ma.xproce.inventoryservice.mapper.ModelMapperConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CreatorManagerImpl implements CreatorManager{

    @Autowired
    private CreatorRepository creatorRepository;
    @Autowired
    private ModelMapperConfig creatorMapper;



    @Override
    public CreatorDto creatorById(Long id) {
        return creatorMapper.fromCreatorToCreatorDto(creatorRepository.findById(id).get());
    }

    @Override
    public CreatorDto saveCreator(CreatorDto creatorDto) {
        return creatorMapper.fromCreatorToCreatorDto(creatorRepository.save(creatorMapper.fromCreatorDtoToCreator(creatorDto)));
    }

    @Override
    public List<CreatorDto> findAllCreator() {
        List<Creator> creators=creatorRepository.findAll();
        List<CreatorDto> creatorDtos=creators.stream()
                .map(creatorMapper::fromCreatorToCreatorDto)
                .collect(Collectors.toList());
        return creatorDtos;
    }

}
