package soloproject.demo.member.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import soloproject.demo.member.dto.MemberDto;
import soloproject.demo.member.entity.Member;
import soloproject.demo.member.mapper.MemberMapper;
import soloproject.demo.member.service.MemberService;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1/members")
@Validated
public class MemberController {
  private final MemberService memberService;
  private final MemberMapper memberMapper;

  public MemberController(MemberService memberService, MemberMapper memberMapper) {
    this.memberService = memberService;
    this.memberMapper = memberMapper;
  }

  @PostMapping
  public ResponseEntity postMember(@Valid @RequestBody MemberDto.Post requestBody) {

    Member request = memberMapper.memberPostDtoToMember(requestBody);
    Member member = memberService.createMember(request);
    MemberDto.Response response = memberMapper.memberToMemberResponseDto(member);

    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @PatchMapping("/{member-id}")
  public ResponseEntity patchMember(@PathVariable("member-id") @Positive long memberId,
                                    @Valid @RequestBody MemberDto.Patch requestBody) {
    requestBody.setMemberId(memberId);

    Member request = memberMapper.memberPatchDtoToMember(requestBody);
    Member member = memberService.updateMember(request);
    MemberDto.Response response = memberMapper.memberToMemberResponseDto(member);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/{member-id}")
  public ResponseEntity getMember(@PathVariable("member-id") @Positive long memberId) {

    Member member = memberService.findMember(memberId);
    MemberDto.Response response = memberMapper.memberToMemberResponseDto(member);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity getMembers() {

    List<Member> members = memberService.findMembers();
    List<MemberDto.Response> response = members.stream().map(member -> memberMapper.memberToMemberResponseDto(member)).collect(Collectors.toList());

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @DeleteMapping("/{member-id}")
  public ResponseEntity deleteMember(@PathVariable("order-id") @Positive long memberId) {
    memberService.deleteMember(memberId);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
