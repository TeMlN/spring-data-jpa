package com.jpa.DataJpa.repository;

import com.jpa.DataJpa.model.Member;

import java.util.List;

public interface MemberRepositoryCustom {

    List<Member> findMemberCustom();
}
