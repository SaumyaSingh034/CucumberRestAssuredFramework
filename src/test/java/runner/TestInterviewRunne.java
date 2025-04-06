package runner;


import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
        features = "write the path of feature",
        glue = "write the path of stepdef",
        plugin = {"pretty", "json"}
)
public class TestInterviewRunne  {
}
