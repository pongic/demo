package soloproject.demo.member.mapper;

import org.mapstruct.Mapper;
import soloproject.demo.member.dto.MemberPostDto;
import soloproject.demo.member.dto.MemberResponseDto;
import soloproject.demo.member.entity.Member;

@Mapper(componentModel = "spring")
public interface MemberMapper {
  Member memberPostDtoToMember(MemberPostDto memberPostDto);

  MemberResponseDto memberToMemberResponseDto(Member member);
}
