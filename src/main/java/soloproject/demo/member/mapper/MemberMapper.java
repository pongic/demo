package soloproject.demo.member.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import soloproject.demo.member.dto.MemberDto;
import soloproject.demo.member.entity.Member;

@Mapper(componentModel = "spring")
public interface MemberMapper {
  Member memberPostDtoToMember(MemberDto.Post memberPostDto);
  Member memberPatchDtoToMember(MemberDto.Patch memberPatchDto);
  MemberDto.Response memberToMemberResponseDto(Member member);
}
