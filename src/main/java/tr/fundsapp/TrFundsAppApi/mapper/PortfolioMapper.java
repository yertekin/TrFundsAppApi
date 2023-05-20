package tr.fundsapp.TrFundsAppApi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tr.fundsapp.TrFundsAppApi.data.dao.UserPortfolio;
import tr.fundsapp.TrFundsAppApi.service.dto.UserPortfolioResponse;

@Mapper
public interface PortfolioMapper {

    @Mapping(source = "fundId.fundCode", target = "fundCode")
    @Mapping(source = "fundId.date", target = "date")
    UserPortfolioResponse toUserPortfolioResponse(UserPortfolio portfolio);
}
