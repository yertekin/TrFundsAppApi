package tr.fundsapp.TrFundsAppApi.data.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.ToString;

import java.io.Serializable;

@Embeddable
@ToString
public class FundPriceId implements Serializable {

    @Column(name = "date")
    private String date;
    @Column(name = "fund_code")
    private String fundCode;

    public FundPriceId() {
    }

}
