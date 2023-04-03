package com.example.currencyconversion;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class CurrencyConversionController {
    private static final String API_KEY = "MxRfIj7FfTxCFCmL6905hvUeapmQGoZu";
    private static final String API_URL = "https://api.apilayer.com/exchangerates_data/convert";

    @GetMapping("/convert")
    public String convert(@RequestParam String from, @RequestParam String to, @RequestParam double amount, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = API_URL + "?from=" + from + "&to=" + to + "&amount=" + amount + "&apikey=" + API_KEY;
        CurrencyConversionResponse response = restTemplate.getForObject(apiUrl, CurrencyConversionResponse.class);
        double convertedAmount = response.getResult();
        model.addAttribute("convertedAmount", convertedAmount);
        return "result";
    }
}
