package com.xproce.inventoryservice.web;

import com.xproce.inventoryservice.dao.dto.Creatordto;
import com.xproce.inventoryservice.dao.dto.Videodto;
import com.xproce.inventoryservice.dao.repository.CreatorRepository;
import com.xproce.inventoryservice.dao.repository.VideoRepository;
import com.xproce.inventoryservice.dao.entities.Creator;
import com.xproce.inventoryservice.dao.entities.Video;
import com.xproce.inventoryservice.mappers.Mappers;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class VideoGraphQlController {
    private CreatorRepository creatorRepository;
    private VideoRepository videoRepository;
    private Mappers mapper;
    VideoGraphQlController(CreatorRepository creatorRepository, VideoRepository videoRepository,Mappers map){
        this.creatorRepository = creatorRepository;
        this.videoRepository = videoRepository;
        this.mapper = map;
    }
    @QueryMapping
    public List<Video> videoList(){
        return videoRepository.findAll();
    }

    @QueryMapping
    public Video videoById(@Argument Integer id){
        return videoRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Creator %s not found",id)));
    }
    @QueryMapping
    public Creator creatorById(@Argument Integer id) {
        return creatorRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Creator %s not found",id)));
    }
    @QueryMapping
    public List<Creator> creatorList(){
        return creatorRepository.findAll();
    }

    @QueryMapping
    public List<Video> creatorByidVideoList(@Argument Integer id){
        Creator c = creatorById(id);
        List<Video> videos = c.getVideo().stream().toList();
        return videos;
    }
    /*@QueryMapping
    public List<Video> creatorByidVideoList(Integer id){
        Creator c = creatorRepository.findById(id).get();
        List<Video> videos = new ArrayList<>();
        for (Video v : c.getVideo()){
            videos.add(v);
        }
        return videos;
    }
    */

    @MutationMapping
    public Video saveVideo(@Argument Videodto videodto){
        Video video = mapper.fromVideoDtoToVideo(videodto);
        Creatordto creatorDto = videodto.getCreatordto();
        Creator creator = mapper.fromCreatorDtoToCreator(creatorDto);
        Creator savedCreator = creatorRepository.save(creator);
        video.setCreator(savedCreator);
        return videoRepository.save(video);
    }
    @MutationMapping
    public Creator saveCreator(@Argument Creatordto creatordto){
        Creator creator = mapper.fromCreatorDtoToCreator(creatordto);
        return creatorRepository.save(creator);
    }

}
