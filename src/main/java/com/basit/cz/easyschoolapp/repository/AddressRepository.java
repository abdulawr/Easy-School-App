package com.basit.cz.easyschoolapp.repository;

import com.basit.cz.easyschoolapp.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {
}
