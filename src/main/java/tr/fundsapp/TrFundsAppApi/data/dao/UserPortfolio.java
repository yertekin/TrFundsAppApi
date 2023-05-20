package tr.fundsapp.TrFundsAppApi.data.dao;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "user_portfolio")
@ToString
@Data
public class UserPortfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String username;

    private FundId fundId;

    private int quantity;

    @NotBlank
    private String operation;

}
