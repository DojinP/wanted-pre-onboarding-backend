package idv.wantedpreonboardingbackend.custom;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL) // null 값을 갖는 필드는 JSON 응답에 포함되지 않음을 의미
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Response<T>{
    private String success;
    private String message;
    private T data;
}
