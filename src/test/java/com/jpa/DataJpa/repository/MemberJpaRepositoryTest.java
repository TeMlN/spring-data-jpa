package com.jpa.DataJpa.repository;

import com.jpa.DataJpa.model.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
//@Rollback(value = false) 테스트한 결과를 db에 저장하겠다는 annotation
public class MemberJpaRepositoryTest {

    @Autowired MemberJpaRepository memberJpaRepository;

    @Test
    public void testMember() {
        Member member = new Member("memberA");
        Member save = memberJpaRepository.save(member);

        Member member1 = memberJpaRepository.find(save.getId());

        Assertions.assertEquals(member1.getUsername(), member.getUsername());

    }
}
