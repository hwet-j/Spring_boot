
package com.coding.project.dto.auth;


import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MemberDTO {

    @NotBlank(message = "이름은 필수 입력 항목입니다.")
    private String name;

    @NotBlank(message = "닉네임은 필수 입력 항목입니다.")
    @Size(min = 3, max = 12, message = "닉네임은 3자 이상 12자 이하로 입력해야 합니다.")
    private String nickname;

    @Size(min = 6, max = 16, message = "비밀번호는 6자 이상 16자 이하로 입력해야 합니다.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$",
            message = "비밀번호는 대문자, 소문자, 숫자를 모두 포함해야 합니다.")
    private String password;

    private String email;

    @Past(message = "생년월일은 과거 날짜여야 합니다.")
    private LocalDate birthDate;

    @NotBlank(message = "성별은 필수 입력 항목입니다.")
    private String gender;

    private boolean allowEmail;

}

