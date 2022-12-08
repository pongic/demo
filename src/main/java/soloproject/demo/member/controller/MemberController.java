package soloproject.demo.member.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import soloproject.demo.member.dto.MemberDto;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("v1/members")
@Validated
public class MemberController {
  @PostMapping
  public ResponseEntity postMember(@Valid @RequestBody MemberDto.Post requestBody) {

    return new ResponseEntity<>(requestBody, HttpStatus.CREATED);
  }

  @PatchMapping("/{member-id}")
  public ResponseEntity patchMember(@PathVariable("member-id") @Positive long memberId,
                                    @Valid @RequestBody MemberDto.Patch requestBody) {
    requestBody.setMemberId(memberId);
    requestBody.setName("홍길동");

    return new ResponseEntity<>(requestBody, HttpStatus.OK);
  }

  @GetMapping("/{member-id}")
  public ResponseEntity getMember(@PathVariable("member-id") @Positive long memberId) {
    System.out.println("#memberId: " + memberId);

    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity getMembers() {
    System.out.println("# get Members");

    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping("/{member-id}")
  public ResponseEntity deleteMember(@PathVariable("order-id") @Positive long orderId) {
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
