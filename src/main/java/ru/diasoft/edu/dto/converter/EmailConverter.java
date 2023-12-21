package ru.diasoft.edu.dto.converter;

import lombok.experimental.UtilityClass;
import ru.diasoft.edu.domain.Email;
import ru.diasoft.edu.domain.Person;
import ru.diasoft.edu.dto.EmailDto;

@UtilityClass
public class EmailConverter {

    public Email toEntity(EmailDto emailDto, Person person) {

        return Email.builder()
                .id(emailDto.getId())
                .emailAddress(emailDto.getEmailAddress())
                .person(person)
                .build();
    }

    public EmailDto toDto(Email email) {

        return EmailDto.builder()
                .id(email.getId())
                .emailAddress(email.getEmailAddress())
                .build();
    }

}
