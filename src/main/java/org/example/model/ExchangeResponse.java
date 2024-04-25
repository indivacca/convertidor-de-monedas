package org.example.model;

public class ExchangeResponse {
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public ConversionObj getConversion_rates() {
        return conversion_rates;
    }

    public void setConversion_rates(ConversionObj conversion_rates) {
        this.conversion_rates = conversion_rates;
    }

    private ConversionObj conversion_rates;


}
