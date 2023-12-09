package com.xproce.inventoryservice;

import com.xproce.inventoryservice.dao.entities.Creator;
import com.xproce.inventoryservice.dao.entities.Video;
import com.xproce.inventoryservice.dao.repository.CreatorRepository;
import com.xproce.inventoryservice.dao.repository.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	/*@Bean
	CommandLineRunner start(CreatorRepository creatorRepository, VideoRepository videoRepository){
		return args -> {
			Creator creator = Creator.builder().name("el hachmy").email("elhachmy@gmail.com").build();
			creatorRepository.save(creator);
			Creator creator1 = Creator.builder().name("yassine").email("yassine@gmail.com").build();
			creatorRepository.save(creator1);
			Video video = Video.builder().name("video1").url("video1.com").creator(creator).build();
			Video video2 = Video.builder().name("video2").url("video2.com").creator(creator1).build();
			videoRepository.save(video);
			videoRepository.save(video2);
		};
	}*/
}
