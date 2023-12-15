package ma.xproce.inventoryservice.service;

import ma.xproce.inventoryservice.dtos.VideoDto;

import java.util.List;

public interface VideoManager {
    public VideoDto videoById(Long id);
    public VideoDto saveVideo(VideoDto videoDto);
    public List<VideoDto> findAllVideo();
    public VideoDto updateVideo(VideoDto videoDto);
}
