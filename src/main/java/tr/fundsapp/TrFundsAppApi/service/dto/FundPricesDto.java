package tr.fundsapp.TrFundsAppApi.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FundPricesDto {

    private String date;
    private String fundCode;
    private Double price;
    private Double totalFundValue;

}
