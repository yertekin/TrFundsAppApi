package tr.fundsapp.TrFundsAppApi.service.serviceImpl;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import tr.fundsapp.TrFundsAppApi.data.FundPricesRepository;
import tr.fundsapp.TrFundsAppApi.data.UserPortfolioRepository;
import tr.fundsapp.TrFundsAppApi.data.dao.FundId;
import tr.fundsapp.TrFundsAppApi.data.dao.FundPrice;
import tr.fundsapp.TrFundsAppApi.data.dao.UserPortfolio;
import tr.fundsapp.TrFundsAppApi.mapper.PortfolioMapper;
import tr.fundsapp.TrFundsAppApi.service.dto.UserPortfolioRequest;
import tr.fundsapp.TrFundsAppApi.service.dto.UserPortfolioResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserPortfolioService {

    @Autowired
    UserPortfolioRepository portfolioRepository;

    @Autowired
    FundPricesRepository pricesRepository;

    PortfolioMapper mapper = Mappers.getMapper(PortfolioMapper.class);

    public UserPortfolioService(UserPortfolioRepository portfolioRepository, FundPricesRepository pricesRepository) {
        this.portfolioRepository = portfolioRepository;
        this.pricesRepository = pricesRepository;
    }

    public boolean portfolioTransaction(UserPortfolioRequest request) {

        String username = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        System.out.println("userPortfolioService username: " + username);

        FundId fundId = new FundId();
        fundId.setFundCode(request.getFundCode());
        fundId.setDate(request.getDate());

        UserPortfolio userPortfolio = new UserPortfolio();
        userPortfolio.setUsername(username);
        userPortfolio.setFundId(fundId);
        userPortfolio.setOperation(request.getOperation());
        userPortfolio.setQuantity(request.getQuantity());
        userPortfolio = portfolioRepository.save(userPortfolio);

        return userPortfolio.getId() != null;
    }

    public List<UserPortfolioResponse> getUserPortfolio() {

        String username = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        List<UserPortfolio> userPortfolio = (List<UserPortfolio>) portfolioRepository.findByUsername(username);
        List<UserPortfolioResponse> responseList = new ArrayList<>();
        for (UserPortfolio portfolioDao: userPortfolio) {
            new UserPortfolioResponse();
            UserPortfolioResponse userPortfolioResponse = mapper.toUserPortfolioResponse(portfolioDao);
            FundId fundId = portfolioDao.getFundId();
            Optional<FundPrice> fundPrice = pricesRepository.findById(fundId);
            if (fundPrice.isPresent()) {
                userPortfolioResponse.setPrice(fundPrice.map(FundPrice::getPrice).orElse(null));
            }
            responseList.add(userPortfolioResponse);
        }
        return responseList;
    }
}
