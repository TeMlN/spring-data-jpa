package com.jpa.DataJpa.repository;

import com.jpa.DataJpa.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByUsername(String username); //구현하지 않아도 동작(별도의 Impl, Custom 없이)

}
