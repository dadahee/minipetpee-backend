package com.j2kb.minipetpee.api.homepee.repository;

import com.j2kb.minipetpee.api.homepee.domain.Homepee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomepeeRepository extends JpaRepository<Homepee, Long> {
}
