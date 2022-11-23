package soloproject.demo.member.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import soloproject.demo.member.dto.MemberPostDto;
import soloproject.demo.member.entity.Member;
import soloproject.demo.member.mapper.MemberMapper;
import soloproject.demo.member.service.MemberService;

@RestController
@RequestMapping("/v1/members")
public class MemberController {

  private final MemberService memberService;
  private final MemberMapper mapper;

  public MemberController(MemberService memberService, MemberMapper mapper) {
    this.memberService = memberService;
    this.mapper = mapper;
  }

  @PostMapping
  public ResponseEntity postMember(@RequestBody MemberPostDto memberPostDto) {
    Member member = mapper.memberPostDtoToMember(memberPostDto);
    Member createdMember = memberService.createMember(member);

    return new ResponseEntity(mapper.memberToMemberResponseDto(createdMember), HttpStatus.CREATED);
  }

}
