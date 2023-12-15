package ma.xproce.inventoryservice.service;

import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dao.entities.Video;
import ma.xproce.inventoryservice.dao.repositories.VideoRepository;
import ma.xproce.inventoryservice.dtos.CreatorDto;
import ma.xproce.inventoryservice.dtos.VideoDto;
import ma.xproce.inventoryservice.mapper.ModelMapperConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VideoManagerImpl implements VideoManager{

    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private ModelMapperConfig videoMapper;

    @Override
    public VideoDto videoById(Long id) {
        return videoMapper.fromVideoToVideoDto(videoRepository.findById(id).get());
    }

    @Override
    public VideoDto saveVideo(VideoDto videoDto) {
        return videoMapper.fromVideoToVideoDto(videoRepository.save(videoMapper.fromVideoDtoToVideo(videoDto)));
    }

    @Override
    public List<VideoDto> findAllVideo() {
        List<Video> videos=videoRepository.findAll();
        List<VideoDto> videoDtos=videos.stream()
                .map(videoMapper::fromVideoToVideoDto)
                .collect(Collectors.toList());
        return videoDtos;
    }

    @Override
    public VideoDto updateVideo(VideoDto videoDto) {
        return videoMapper.fromVideoToVideoDto(videoRepository.save(videoMapper.fromVideoDtoToVideo(videoDto)));
    }
}
