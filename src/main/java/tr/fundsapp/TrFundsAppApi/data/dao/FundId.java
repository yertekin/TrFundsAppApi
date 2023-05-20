package tr.fundsapp.TrFundsAppApi.data.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Embeddable
@Data
@ToString
public class FundId implements Serializable {

    @Column(name = "date")
    private String date;
    @Column(name = "fund_code")
    private String fundCode;

    public FundId() {
    }

}
