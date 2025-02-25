package com.example.demo.mappers;

import com.example.demo.Dtos.AuthorDto;
import com.example.demo.domain.AuthorEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper implements Mapper<AuthorDto, AuthorEntity> {

    private final ModelMapper modelMapper;

    public AuthorMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public AuthorEntity mapTo(AuthorDto authorDto) {
        return modelMapper.map(authorDto, AuthorEntity.class);
    }

    @Override
    public AuthorDto mapFrom(AuthorEntity authorEntity) {
        return modelMapper.map(authorEntity,AuthorDto.class);

    }
}
