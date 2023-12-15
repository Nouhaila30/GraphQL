package ma.xproce.inventoryservice.dtos;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class VideoDto {
    private String name;
    private String url;
    private String description;
    private Date datePublication;
    private CreatorDto creator;
}
