package com.Carbon;

public class ForecastRegion {
    private int forecast;
    private String shortName;
    public ForecastRegion(Region region) {
        this.forecast = region.getIntensity().getForecast();
        this.shortName = region.getShortname();
    }

    public int getForecast() {
        return forecast;
    }

    public void setForecast(int forecast) {
        this.forecast = forecast;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

}
