package tr.fundsapp.TrFundsAppApi.data.dao;

import jakarta.persistence.*;

@Entity
@IdClass(FundPriceId.class)
@Table(name = "fund_prices")
public class FundPrice {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String date;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String fund_code;
    private Double price;
    private Double total_fund_value;
}
