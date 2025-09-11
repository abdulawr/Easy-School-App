package com.basit.cz.easyschoolapp.repository;

import com.basit.cz.easyschoolapp.model.EazyClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EazyClassRepository extends JpaRepository<EazyClass, Integer> {
}
