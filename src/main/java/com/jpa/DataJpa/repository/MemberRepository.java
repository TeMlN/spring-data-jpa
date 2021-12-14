package com.jpa.DataJpa.repository;

import com.jpa.DataJpa.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {


}
