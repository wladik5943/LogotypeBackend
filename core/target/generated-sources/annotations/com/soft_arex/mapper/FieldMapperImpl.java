package com.soft_arex.mapper;

import com.soft_arex.entity.Field;
import com.soft_arex.field.model.FieldRequestDTO;
import com.soft_arex.field.model.FieldResponseDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-21T10:32:17+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class FieldMapperImpl implements FieldMapper {

    @Override
    public FieldResponseDTO toResponse(Field field) {
        if ( field == null ) {
            return null;
        }

        FieldResponseDTO fieldResponseDTO = new FieldResponseDTO();

        fieldResponseDTO.setId( field.getId() );
        fieldResponseDTO.setLabel( field.getLabel() );
        fieldResponseDTO.setType( field.getType() );
        fieldResponseDTO.setRequired( field.isRequired() );
        fieldResponseDTO.setActive( field.isActive() );
        List<String> list = field.getOptions();
        if ( list != null ) {
            fieldResponseDTO.setOptions( new ArrayList<String>( list ) );
        }

        return fieldResponseDTO;
    }

    @Override
    public Field toEntity(FieldRequestDTO request) {
        if ( request == null ) {
            return null;
        }

        Field field = new Field();

        field.setLabel( request.getLabel() );
        field.setType( request.getType() );
        field.setRequired( request.isRequired() );
        field.setActive( request.isActive() );
        List<String> list = request.getOptions();
        if ( list != null ) {
            field.setOptions( new ArrayList<String>( list ) );
        }

        return field;
    }
}
