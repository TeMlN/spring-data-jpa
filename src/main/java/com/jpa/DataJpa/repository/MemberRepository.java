package com.jpa.DataJpa.repository;

import com.jpa.DataJpa.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByUsernameAndAgeGreaterThan(String username, int age);

    @Query("select m from Member m where m.username = :username and m.age = :age") // 오타가 나면 Application 로딩 시점에 에러가 잡힘 Named query와 비슷
    List<Member> findUser(@Param("username") String username, @Param("age") int age);
}
