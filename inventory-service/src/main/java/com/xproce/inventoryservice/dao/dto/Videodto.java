package com.xproce.inventoryservice.dao.dto;

import lombok.Data;

@Data
public class Videodto {
    String name;
    String  url;
    String description;
    String datePublication;
    Creatordto creatordto;

}
