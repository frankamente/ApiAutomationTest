package com.Carbon;

import java.util.List;
import java.util.Objects;

public class Region {
    private int regionid;
    private String dnoregion;
    private String shortname;
    private Intensity intensity;
    private List<GenerationMix> generationmix;
    private final int DECIMAL_PRECISION = 5;

    public int getRegionid() {
        return regionid;
    }

    public void setRegionid(int regionid) {
        this.regionid = regionid;
    }

    public String getDnoregion() {
        return dnoregion;
    }

    public void setDnoregion(String dnoregion) {
        this.dnoregion = dnoregion;
    }

    String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    Intensity getIntensity() {
        return intensity;
    }

    public void setIntensity(Intensity intensity) {
        this.intensity = intensity;
    }

    public int getIntensityForecast() {
        return this.intensity.getForecast();
    }

    public List<GenerationMix> getGenerationmix() {
        return generationmix;
    }

    public void setGenerationmix(List<GenerationMix> generationmix) {
        this.generationmix = generationmix;
    }

    public double getGenerationMixSum() {
        final double result = generationmix.stream().mapToDouble(GenerationMix::getPerc).sum();
        return round(result);
    }

    private double round(double value) {
        int scale = (int) Math.pow(10, DECIMAL_PRECISION);
        return (double) Math.round(value * scale) / scale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return regionid == region.regionid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(regionid);
    }
}
