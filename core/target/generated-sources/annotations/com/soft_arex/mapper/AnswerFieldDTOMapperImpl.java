package com.soft_arex.mapper;

import com.soft_arex.answer.model.AnswerFieldDTO;
import com.soft_arex.entity.AnswerField;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-21T23:29:03+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class AnswerFieldDTOMapperImpl implements AnswerFieldDTOMapper {

    @Override
    public AnswerFieldDTO toDTO(AnswerField field) {
        if ( field == null ) {
            return null;
        }

        AnswerFieldDTO answerFieldDTO = new AnswerFieldDTO();

        answerFieldDTO.setValue( field.getValue() );

        return answerFieldDTO;
    }
}
