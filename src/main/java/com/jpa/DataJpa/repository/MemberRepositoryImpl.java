package com.jpa.DataJpa.repository;

import com.jpa.DataJpa.model.Member;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {
//Method 재정의를 해서 사용자 정의 쿼리를 날릴때 Repository명 + impl이 규칙이다

    private final EntityManager em;

    @Override
    public List<Member> findMemberCustom() {
         return em.createQuery("select m from Member m")
                 .getResultList();
    }
}
