package tr.fundsapp.TrFundsAppApi.data;

import org.springframework.data.repository.CrudRepository;
import tr.fundsapp.TrFundsAppApi.data.dao.FundPrice;

public interface FundPricesRepository extends CrudRepository<FundPrice, String> {
}
