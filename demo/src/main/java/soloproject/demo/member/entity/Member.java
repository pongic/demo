package soloproject.demo.member.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Member {
  @Id
  private Long memberId;
  private String email;
  private String name;
  private String phone;

  public Member(String email, String name, String phone) {
    this.email = email;
    this.name = name;
    this.phone = phone;
  }
}
