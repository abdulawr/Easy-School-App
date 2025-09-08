package com.basit.cz.easyschoolapp.service;

import com.basit.cz.easyschoolapp.constant.SchoolConstant;
import com.basit.cz.easyschoolapp.model.Person;
import com.basit.cz.easyschoolapp.model.Roles;
import com.basit.cz.easyschoolapp.repository.PersonRepository;
import com.basit.cz.easyschoolapp.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    RolesRepository rolesRepository;

    public boolean createNewPerson(Person person){
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(SchoolConstant.STUDENT_ROLE);
        person.setRoles(role);
        person = personRepository.save(person);
        if (null != person && person.getPersonId() > 0)
        {
            isSaved = true;
        }
        return isSaved;
    }
}
