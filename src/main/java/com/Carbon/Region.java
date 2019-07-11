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

    public List<GenerationMix> getGenerationmix() {
        return generationmix;
    }

    public void setGenerationmix(List<GenerationMix> generationmix) {
        this.generationmix = generationmix;
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
