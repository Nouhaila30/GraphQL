package ma.xproce.inventoryservice.web.controllers;

import ma.xproce.inventoryservice.dtos.CreatorDto;
import ma.xproce.inventoryservice.dtos.VideoDto;
import ma.xproce.inventoryservice.service.CreatorManager;
import ma.xproce.inventoryservice.service.VideoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;


@Controller
public class GraphQlController {
    @Autowired
    private CreatorManager creatorManager;

    @Autowired
    private VideoManager videoManager;


    @QueryMapping
    public VideoDto videoById(@Argument Long id){
        return videoManager.videoById(id);
    }

    @QueryMapping
    public CreatorDto creatorById(@Argument Long id) {
        return creatorManager.creatorById(id);
    }
    @QueryMapping
    public List<CreatorDto> findAllCreator(){
        return creatorManager.findAllCreator();
    }
    @QueryMapping
    public List<VideoDto> findAllVideo(){
        return videoManager.findAllVideo();
    }

    @MutationMapping
    public CreatorDto saveCreator(@Argument CreatorDto creator){
        return creatorManager.saveCreator(creator);
    }

    @MutationMapping
    public VideoDto saveVideo(@Argument VideoDto videoDto){
        return videoManager.saveVideo(videoDto);
    }

    @SubscriptionMapping
    public Flux<VideoDto> notifyVideoChange() {
        return Flux.fromStream(
                Stream.generate(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    Random random = new Random();
                    CreatorDto creatorDto = CreatorDto.builder().name("x" +
                                    new Random().nextInt())
                            .email("x@gmail.com").build();
                    CreatorDto creator = creatorManager.saveCreator(creatorDto);
                    VideoDto video = videoManager.videoById(1L);
                    video.setCreator(creator);
                    videoManager.updateVideo(video);
                    return video;
                }));
    }

}
