package tr.fundsapp.TrFundsAppApi.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tr.fundsapp.TrFundsAppApi.data.FundPricesRepository;
import tr.fundsapp.TrFundsAppApi.data.dao.FundPrice;

@Controller
@RequestMapping(path = "/fundPrices")
public class FundPricesController {

    @Autowired
    private FundPricesRepository fundPricesRepository;

    @GetMapping(path = "/getAll")
    public @ResponseBody Iterable<FundPrice> getAllPrices() {
        return fundPricesRepository.findAll();
    }
}
