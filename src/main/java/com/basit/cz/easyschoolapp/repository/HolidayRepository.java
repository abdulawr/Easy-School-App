package com.basit.cz.easyschoolapp.repository;

import com.basit.cz.easyschoolapp.model.Holiday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidayRepository extends CrudRepository<Holiday, String> {
}
