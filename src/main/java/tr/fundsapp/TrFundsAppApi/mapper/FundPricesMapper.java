package tr.fundsapp.TrFundsAppApi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tr.fundsapp.TrFundsAppApi.data.dao.FundPrice;
import tr.fundsapp.TrFundsAppApi.service.dto.FundPricesDto;

@Mapper
public interface FundPricesMapper {

    @Mapping(source = "id.fundCode", target = "fundCode")
    @Mapping(source = "id.date", target = "date")
    FundPricesDto toFundPricesDto(FundPrice fundPrice);
}
