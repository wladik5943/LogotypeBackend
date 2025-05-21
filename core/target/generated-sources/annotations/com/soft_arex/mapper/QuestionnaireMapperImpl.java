package com.soft_arex.mapper;

import com.soft_arex.entity.Field;
import com.soft_arex.entity.Questionnaire;
import com.soft_arex.field.model.FieldResponseDTO;
import com.soft_arex.questionnaire.model.QuestionnaireResponseDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-21T14:31:11+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class QuestionnaireMapperImpl implements QuestionnaireMapper {

    @Override
    public QuestionnaireResponseDTO toResponse(Questionnaire q) {
        if ( q == null ) {
            return null;
        }

        QuestionnaireResponseDTO questionnaireResponseDTO = new QuestionnaireResponseDTO();

        questionnaireResponseDTO.setId( q.getId() );
        questionnaireResponseDTO.setTitle( q.getTitle() );
        questionnaireResponseDTO.setActive( q.isActive() );
        questionnaireResponseDTO.setFields( fieldListToFieldResponseDTOList( q.getFields() ) );

        return questionnaireResponseDTO;
    }

    protected FieldResponseDTO fieldToFieldResponseDTO(Field field) {
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

    protected List<FieldResponseDTO> fieldListToFieldResponseDTOList(List<Field> list) {
        if ( list == null ) {
            return null;
        }

        List<FieldResponseDTO> list1 = new ArrayList<FieldResponseDTO>( list.size() );
        for ( Field field : list ) {
            list1.add( fieldToFieldResponseDTO( field ) );
        }

        return list1;
    }
}
