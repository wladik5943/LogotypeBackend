package com.soft_arex.mapper;

import com.soft_arex.answer.model.AnswerFieldDTO;
import com.soft_arex.answer.model.AnswerResponse;
import com.soft_arex.answer.model.AnswerResponseMessage;
import com.soft_arex.entity.Answer;
import com.soft_arex.entity.AnswerField;
import com.soft_arex.entity.Field;
import com.soft_arex.entity.Questionnaire;
import com.soft_arex.field.model.FieldResponseDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-21T14:42:23+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class AnswerMapperImpl implements AnswerMapper {

    @Override
    public AnswerResponseMessage toMessage(Answer answer) {
        if ( answer == null ) {
            return null;
        }

        AnswerResponseMessage answerResponseMessage = new AnswerResponseMessage();

        answerResponseMessage.setQuestionnaireId( answerQuestionnaireId( answer ) );
        answerResponseMessage.setQuestionnaireName( answerQuestionnaireTitle( answer ) );
        answerResponseMessage.setId( answer.getId() );
        answerResponseMessage.setAnswers( answerFieldListToAnswerFieldDTOList( answer.getAnswers() ) );

        return answerResponseMessage;
    }

    @Override
    public AnswerResponse toResponse(Answer answer) {
        if ( answer == null ) {
            return null;
        }

        AnswerResponse answerResponse = new AnswerResponse();

        answerResponse.setQuestionnaireId( answerQuestionnaireId( answer ) );
        answerResponse.setQuestionnaireName( answerQuestionnaireTitle( answer ) );
        List<Field> fields = answerQuestionnaireFields( answer );
        answerResponse.setFields( fieldListToFieldResponseDTOList( fields ) );
        answerResponse.setId( answer.getId() );
        answerResponse.setAnswers( answerFieldListToAnswerFieldDTOList( answer.getAnswers() ) );

        return answerResponse;
    }

    @Override
    public AnswerFieldDTO map(AnswerField field) {
        if ( field == null ) {
            return null;
        }

        AnswerFieldDTO answerFieldDTO = new AnswerFieldDTO();

        answerFieldDTO.setFieldId( fieldFieldId( field ) );
        answerFieldDTO.setValue( field.getValue() );

        return answerFieldDTO;
    }

    private Long answerQuestionnaireId(Answer answer) {
        if ( answer == null ) {
            return null;
        }
        Questionnaire questionnaire = answer.getQuestionnaire();
        if ( questionnaire == null ) {
            return null;
        }
        Long id = questionnaire.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String answerQuestionnaireTitle(Answer answer) {
        if ( answer == null ) {
            return null;
        }
        Questionnaire questionnaire = answer.getQuestionnaire();
        if ( questionnaire == null ) {
            return null;
        }
        String title = questionnaire.getTitle();
        if ( title == null ) {
            return null;
        }
        return title;
    }

    protected List<AnswerFieldDTO> answerFieldListToAnswerFieldDTOList(List<AnswerField> list) {
        if ( list == null ) {
            return null;
        }

        List<AnswerFieldDTO> list1 = new ArrayList<AnswerFieldDTO>( list.size() );
        for ( AnswerField answerField : list ) {
            list1.add( map( answerField ) );
        }

        return list1;
    }

    private List<Field> answerQuestionnaireFields(Answer answer) {
        if ( answer == null ) {
            return null;
        }
        Questionnaire questionnaire = answer.getQuestionnaire();
        if ( questionnaire == null ) {
            return null;
        }
        List<Field> fields = questionnaire.getFields();
        if ( fields == null ) {
            return null;
        }
        return fields;
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

    private Long fieldFieldId(AnswerField answerField) {
        if ( answerField == null ) {
            return null;
        }
        Field field = answerField.getField();
        if ( field == null ) {
            return null;
        }
        Long id = field.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
