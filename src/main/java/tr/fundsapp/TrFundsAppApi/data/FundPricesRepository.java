package tr.fundsapp.TrFundsAppApi.data;

import org.springframework.data.repository.CrudRepository;
import tr.fundsapp.TrFundsAppApi.data.dao.FundPrice;
import tr.fundsapp.TrFundsAppApi.data.dao.FundPriceId;

public interface FundPricesRepository extends CrudRepository<FundPrice, FundPriceId> {
}
