import com.Carbon.CarbonIntensity;
import com.Carbon.CarbonIntensityResponse;
import com.Carbon.ForecastRegion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.util.TreeSet;

import static io.restassured.RestAssured.get;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ApiAutomationTest {

    private final String PATH = "https://api.carbonintensity.org.uk/regional";

    @Test
    public void printRegionSortedByIntensityForecast() {

        final CarbonIntensity carbonIntensity = getCarbonIntensity();

        TreeSet<ForecastRegion> forecastRegion = new TreeSet<>();
        carbonIntensity.getRegions().forEach(region -> forecastRegion.add(new ForecastRegion(region)));
        printSortedRegions(forecastRegion);
    }

    private CarbonIntensity getCarbonIntensity() {
        final CarbonIntensityResponse carbonIntensityResponse =
                get(PATH)
                        .as(CarbonIntensityResponse.class);
        final CarbonIntensity carbonIntensity = carbonIntensityResponse.getData().get(0);

        assertThat(carbonIntensityResponse.getData()).asList().isNotEmpty();
        return carbonIntensity;
    }

    private void printSortedRegions(TreeSet<ForecastRegion> forecastRegion) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(forecastRegion);
        System.out.println(jsonString);
    }

}
