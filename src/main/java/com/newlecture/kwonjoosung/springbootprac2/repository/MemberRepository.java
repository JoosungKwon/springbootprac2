package com.newlecture.kwonjoosung.springbootprac2.repository;


import com.newlecture.kwonjoosung.springbootprac2.domain.member.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long Id);
    Optional<Member> findByName(String Name);
    List<Member> findAll();


}
