package com.jpa.DataJpa.repository;

import com.jpa.DataJpa.dto.MemberDto;
import com.jpa.DataJpa.model.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByUsername(String username);

    List<Member> findByUsernameAndAgeGreaterThan(String username, int age);

    @Query("select m from Member m where m.username = :username and m.age = :age") // 오타가 나면 Application 로딩 시점에 에러가 잡힘 Named query와 비슷
    List<Member> findUser(@Param("username") String username, @Param("age") int age);

    @Query("select m.username from Member m")
    List<String> findUsernameList();

    @Query("select new com.jpa.DataJpa.dto.MemberDto(m.id, m.username, t.name) from Member m join m.team t")
    List<MemberDto> findMemberDto();

    @Query("select m from Member m where m.username in :names")
    List<Member> findByNames(@Param("names") Collection<String> names);

    Member findMemberByUsername(String username);
    Optional<Member> findOptionalByUsername(String username);
    List<Member> findListByUsername(String username);

    @Query(value = "select m from Member m", countQuery = "select count(m.username) from Member m")
    Page<Member> findByAge(int age, Pageable pageable);

    @Modifying // ExecuteUpdate 의 역할임, clearAutomatically = true로 옵션을 주면 em.clear와 같은 기능을 할 수 있다.
    @Query("update Member m set m.age = m.age + 1 where m.age >= :age")
    int bulkAgePlus(@Param("age") int age);

}
