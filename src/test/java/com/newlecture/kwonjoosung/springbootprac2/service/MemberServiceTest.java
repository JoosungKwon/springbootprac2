package com.newlecture.kwonjoosung.springbootprac2.service;


import com.newlecture.kwonjoosung.springbootprac2.domain.member.Member;
import com.newlecture.kwonjoosung.springbootprac2.repository.MemoryMemberRepository;
import com.newlecture.kwonjoosung.springbootprac2.service.member.MemberService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemberServiceTest {

    MemoryMemberRepository memberRepository;
    MemberService memberService ;

    @BeforeEach
    public void beforeEach(){
        this.memberRepository = new MemoryMemberRepository();
        this.memberService = new MemberService(memberRepository);

    }

    @AfterEach
    public void afterEach() {memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("start");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }
    @Test
    void 중복_회원가입(){

    }
    @Test
    void findMembers() {
        //given
        Member member = new Member();
        member.setName("hello");
        memberService.join(member);

        Member member2 = new Member();
        member.setName("hello2");
        memberService.join(member2);

        Member member3 = new Member();
        member.setName("hello3");
        memberService.join(member3);

        //when
        List<Member> findMemberList = memberService.findMembers();

        //then
        assertThat(findMemberList.size()).isEqualTo(3);

    }

    @Test
    void findOne() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }
}