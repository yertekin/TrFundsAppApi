package tr.fundsapp.TrFundsAppApi.rest.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tr.fundsapp.TrFundsAppApi.model.security.MessageResponse;
import tr.fundsapp.TrFundsAppApi.service.dto.UserPortfolioRequest;
import tr.fundsapp.TrFundsAppApi.service.dto.UserPortfolioResponse;
import tr.fundsapp.TrFundsAppApi.service.serviceImpl.UserPortfolioService;

import java.util.List;

@Controller
@RequestMapping(path = "/myPortfolio")
public class PortfolioController {

    @Autowired
    UserPortfolioService portfolioService;

    @PostMapping(path = "/tradeFund")
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    public ResponseEntity<?> trade(@Valid @RequestBody UserPortfolioRequest request) {
        boolean saved = portfolioService.portfolioTransaction(request);
        return saved ? ResponseEntity.ok().body(new MessageResponse("Transaction saved successfully.")) : ResponseEntity.internalServerError().body(new MessageResponse("An error occurred. Please check the fund details and try again."));
    }

    @GetMapping(path = "/getPortfolio")
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    public ResponseEntity<?> getPortfolio() {
        List<UserPortfolioResponse> userPortfolioResponse = portfolioService.getUserPortfolio();
        return ResponseEntity.ok(userPortfolioResponse);
    }

}
