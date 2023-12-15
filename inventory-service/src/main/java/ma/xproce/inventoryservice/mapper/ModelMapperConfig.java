package ma.xproce.inventoryservice.mapper;

import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dao.entities.Video;
import ma.xproce.inventoryservice.dtos.CreatorDto;
import ma.xproce.inventoryservice.dtos.VideoDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperConfig {
    private final ModelMapper modelMapper=new ModelMapper();
    public CreatorDto fromCreatorToCreatorDto(Creator creator){
        return this.modelMapper.map(creator, CreatorDto.class);
    }

    public Creator fromCreatorDtoToCreator(CreatorDto creatorDto){
        return this.modelMapper.map(creatorDto, Creator.class);
    }

    public VideoDto fromVideoToVideoDto(Video video){
        return this.modelMapper.map(video, VideoDto.class);
    }

    public Video fromVideoDtoToVideo(VideoDto videoDto){
        return this.modelMapper.map(videoDto, Video.class);
    }

}
