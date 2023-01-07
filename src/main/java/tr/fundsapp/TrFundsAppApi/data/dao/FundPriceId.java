package tr.fundsapp.TrFundsAppApi.data.dao;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@EqualsAndHashCode
@ToString
@Embeddable
public class FundPriceId implements Serializable {

    @Serial
    private static final long serialVersionUID = -1L;

    private String date;
    private String fund_code;

    public FundPriceId(String date, String fund_code) {
        this.date = date;
        this.fund_code = fund_code;
    }
}
