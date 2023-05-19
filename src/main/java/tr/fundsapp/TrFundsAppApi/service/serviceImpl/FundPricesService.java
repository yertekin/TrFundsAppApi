package tr.fundsapp.TrFundsAppApi.service.serviceImpl;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.fundsapp.TrFundsAppApi.data.FundPricesRepository;
import tr.fundsapp.TrFundsAppApi.data.dao.FundPrice;
import tr.fundsapp.TrFundsAppApi.data.dao.FundPriceId;
import tr.fundsapp.TrFundsAppApi.mapper.FundPricesMapper;
import tr.fundsapp.TrFundsAppApi.service.dto.FundPricesDto;

import java.util.List;
import java.util.Optional;

@Service
public class FundPricesService {

    FundPricesMapper mapper = Mappers.getMapper(FundPricesMapper.class);

    @Autowired
    FundPricesRepository repository;

    public FundPricesService(FundPricesRepository repository) {
        this.repository = repository;
    }

    public List<FundPrice> getAllPrices() {
        return (List<FundPrice>) repository.findAll();
    }

    public FundPricesDto getPriceById(String fundCode, String date) {
        FundPriceId fundPriceId = new FundPriceId();
        fundPriceId.setDate(date);
        fundPriceId.setFundCode(fundCode);
        Optional<FundPrice> fundPrice = repository.findById(fundPriceId);
        return fundPrice.map(price -> mapper.toFundPricesDto(price)).orElse(null);
    }

}
