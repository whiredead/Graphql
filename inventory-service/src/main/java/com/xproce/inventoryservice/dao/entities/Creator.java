package com.xproce.inventoryservice.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Creator {
    @Id @GeneratedValue(strategy = GenerationType.AUTO )
    Integer id;
    String name;
    String email;
    @OneToMany(mappedBy = "creator")
    Collection<Video> video;
}
