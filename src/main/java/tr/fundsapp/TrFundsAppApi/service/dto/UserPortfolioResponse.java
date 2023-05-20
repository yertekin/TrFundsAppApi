package tr.fundsapp.TrFundsAppApi.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserPortfolioResponse {

    private String fundCode;
    private String date;
    private int quantity;
    private String operation;
    private double price;

}
