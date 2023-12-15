package ma.xproce.inventoryservice;

import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dao.entities.Video;
import ma.xproce.inventoryservice.dao.repositories.CreatorRepository;
import ma.xproce.inventoryservice.dao.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);

    }

    @Bean
    CommandLineRunner start(CreatorRepository creatorRepository, VideoRepository videoRepository){
        return args -> {
            Creator creator1,creator2;
            creator1 = creatorRepository.save(Creator.builder().name("Ali").email("ali@gmail.com").build());
            creator2 = creatorRepository.save(Creator.builder().name("Imane").email("imane@gmail.com").build());
            videoRepository.save(Video.builder().name("First Video").url("www.firstVideo.com").description("this is the first video").datePublication(new Date()).creator(creator1).build());
            videoRepository.save(Video.builder().name("Second Video").url("www.secondVideo.com").description("this is the second video").datePublication(new Date()).creator(creator2).build());
            videoRepository.save(Video.builder().name("Third Video").url("www.thirdVideo.com").description("this is the third video").datePublication(new Date()).creator(creator2).build());

        };
    }

}
