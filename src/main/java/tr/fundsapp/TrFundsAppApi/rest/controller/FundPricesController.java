package tr.fundsapp.TrFundsAppApi.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tr.fundsapp.TrFundsAppApi.data.dao.FundPrice;
import tr.fundsapp.TrFundsAppApi.service.dto.FundPricesDto;
import tr.fundsapp.TrFundsAppApi.service.serviceImpl.FundPricesService;

import java.util.List;


@Controller
@RequestMapping(path = "/fundPrices")
public class FundPricesController {

    @Autowired
    private FundPricesService service;

    @GetMapping(path = "/getAll")
    public @ResponseBody
    List<FundPrice> getAllPrices() {
        return service.getAllPrices();
    }

    @GetMapping(path = "/getOne")
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    public @ResponseBody
    FundPricesDto getOneById(@RequestParam String fundCode,
                             @RequestParam String date) {
        return service.getPriceById(fundCode, date);
    }
}
