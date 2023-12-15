package ma.xproce.inventoryservice.service;

import ma.xproce.inventoryservice.dtos.CreatorDto;

import java.util.List;

public interface CreatorManager {
    public CreatorDto creatorById(Long id);
    public CreatorDto saveCreator(CreatorDto creatorDto);
    public List<CreatorDto> findAllCreator();
}
