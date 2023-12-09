package com.xproce.inventoryservice.mappers;

import com.xproce.inventoryservice.dao.dto.Creatordto;
import com.xproce.inventoryservice.dao.dto.Videodto;
import com.xproce.inventoryservice.dao.entities.Creator;
import com.xproce.inventoryservice.dao.entities.Video;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Mappers {
    private ModelMapper modelMapper = new ModelMapper();
    public Video fromVideoDtoToVideo(Videodto videodto){
        return this.modelMapper.map(videodto,Video.class);
    }
    public Creator fromCreatorDtoToCreator(Creatordto creatordto){
        return this.modelMapper.map(creatordto,Creator.class);
    }
}
