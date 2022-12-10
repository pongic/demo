package soloproject.demo.member.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import soloproject.demo.member.dto.MemberDto;
import soloproject.demo.member.entity.Member;
import soloproject.demo.member.service.MemberService;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("v1/members")
@Validated
public class MemberController {
  private final MemberService memberService;

  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }

  @PostMapping
  public ResponseEntity postMember(@Valid @RequestBody MemberDto.Post requestBody) {

    Member member = new Member();
    member.setEmail(requestBody.getEmail());
    member.setName(requestBody.getName());
    member.setPhone(requestBody.getPhone());

    Member response = memberService.createMember(member);

    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @PatchMapping("/{member-id}")
  public ResponseEntity patchMember(@PathVariable("member-id") @Positive long memberId,
                                    @Valid @RequestBody MemberDto.Patch requestBody) {
    requestBody.setMemberId(memberId);

    Member member = new Member();
    member.setMemberId(requestBody.getMemberId());
    member.setName(requestBody.getName());
    member.setPhone(requestBody.getPhone());

    Member response = memberService.updateMember(member);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/{member-id}")
  public ResponseEntity getMember(@PathVariable("member-id") @Positive long memberId) {

    Member response = memberService.findMember(memberId);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity getMembers() {
    List<Member> response = memberService.findMembers();

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @DeleteMapping("/{member-id}")
  public ResponseEntity deleteMember(@PathVariable("order-id") @Positive long memberId) {
    memberService.deleteMember(memberId);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
