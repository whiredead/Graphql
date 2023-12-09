package com.xproce.inventoryservice.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Video {
    @Id @GeneratedValue(strategy = GenerationType.AUTO )
    int id;
    String name;
    String url;
    String  description;
    String  datePublication;
    @ManyToOne
    Creator creator;
}
