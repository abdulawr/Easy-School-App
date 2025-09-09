package com.basit.cz.easyschoolapp.security;

import com.basit.cz.easyschoolapp.model.Person;
import com.basit.cz.easyschoolapp.model.Roles;
import com.basit.cz.easyschoolapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomUsernameAndPwdAuth implements AuthenticationProvider {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();
        Person person = personRepository.findByEmail(email);

        if (person != null && person.getPersonId() > 0 && encoder.matches(password,person.getPwd())){
            return new UsernamePasswordAuthenticationToken(
                    person.getName(), password, getGrantedAuthorities(person.getRoles()));
        }

        throw new BadCredentialsException("Invalid username or password");
    }

    private List<GrantedAuthority> getGrantedAuthorities(Roles roles) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+roles.getRoleName()));
        return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
