package soloproject.demo.member.service;

import org.springframework.stereotype.Service;
import soloproject.demo.member.entity.Member;

import java.util.List;

@Service
public class MemberService {
  public Member createMember(Member member) {
    Member createdMember = member;
    return createdMember;
  }

  public Member updateMember(Member member) {
    Member updatedMember = member;
    return updatedMember;
  }

  public Member findMember(long memberId) {
    Member member = new Member(memberId, "hgd@gmail.com", "홍길동", "010-1234-5678");
    return member;
  }

  public List<Member> findMembers() {
    List<Member> members = List.of(
        new Member(1, "hgd@gmail.com", "홍길동", "010-1234-5678"),
        new Member(2, "lml@gmail.com", "이몽룡", "010-1111-2222")
    );
    return members;
  }

  public void deleteMember(long memberId) {
  }
}
