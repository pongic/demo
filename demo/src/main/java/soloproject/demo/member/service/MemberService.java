package soloproject.demo.member.service;

import org.springframework.stereotype.Service;
import soloproject.demo.member.entity.Member;
import soloproject.demo.member.repository.MemberRepository;

@Service
public class MemberService {

  private final MemberRepository memberRepository;

  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  public Member createMember(Member member) {
    return memberRepository.save(member);
  }
}
