package tr.fundsapp.TrFundsAppApi.data.dao;

import jakarta.persistence.*;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Table(name = "fund_prices")
@ToString
public class FundPrice implements Serializable {


    @EmbeddedId FundPriceId id;
    @Column(name = "price")
    private Double price;
    @Column(name = "total_fund_value")
    private Double totalFundValue;
}
