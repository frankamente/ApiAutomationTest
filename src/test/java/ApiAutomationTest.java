import com.Carbon.CarbonIntensity;
import com.Carbon.CarbonIntensityResponse;
import com.Carbon.ForecastRegion;
import com.Carbon.Region;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static io.restassured.RestAssured.get;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ApiAutomationTest {

    private final String PATH = "https://api.carbonintensity.org.uk/regional";

    private Gson gson;

    public ApiAutomationTest() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Test
    public void printRegionSortedByIntensityForecast() {

        final CarbonIntensity carbonIntensity = getCarbonIntensity();

        final List<ForecastRegion> sortedRegion =
                carbonIntensity.getRegions().stream()
                        .sorted(Comparator.comparingInt(Region::getIntensityForecast)
                                .reversed())
                        .map(ForecastRegion::new)
                        .collect(toList());
        printSortedRegions(sortedRegion);
    }

    @Test
    public void generationMixShouldSum100() {
        final CarbonIntensity carbonIntensity = getCarbonIntensity();

        assertThat(carbonIntensity.getRegions()).allMatch(x -> x.getGenerationMixSum() == 100);
    }

    private CarbonIntensity getCarbonIntensity() {
        final CarbonIntensityResponse carbonIntensityResponse =
                get(PATH)
                        .as(CarbonIntensityResponse.class);
        final CarbonIntensity carbonIntensity = carbonIntensityResponse.getData().get(0);

        assertThat(carbonIntensityResponse.getData()).asList().isNotEmpty();
        return carbonIntensity;
    }

    private void printSortedRegions(List<ForecastRegion> forecastRegion) {

        String jsonString = gson.toJson(forecastRegion);
        System.out.println(jsonString);
    }

}
