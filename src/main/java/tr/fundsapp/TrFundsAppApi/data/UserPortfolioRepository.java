package tr.fundsapp.TrFundsAppApi.data;

import org.springframework.data.repository.CrudRepository;
import tr.fundsapp.TrFundsAppApi.data.dao.UserPortfolio;

public interface UserPortfolioRepository extends CrudRepository<UserPortfolio, Long> {

    Iterable<UserPortfolio> findByUsername(String username);

}
