package soloproject.demo.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soloproject.demo.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
