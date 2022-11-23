package soloproject.demo.member.dto;

import lombok.Getter;

@Getter
public class MemberResponseDto {
  private Long memberId;
  private String email;
  private String name;
  private String phone;
}
