package tr.fundsapp.TrFundsAppApi.model.security;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.List;

@Data
public class UserInfoResponse {

    private Long id;
    private String username;
    private String email;
    @Setter(AccessLevel.NONE)
    private List<String> roles;

    public UserInfoResponse(Long id, String username, String email, List<String> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }
}
