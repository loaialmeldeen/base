package utils;

import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Path;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
import static java.nio.file.Files.newInputStream;

public class AllureUtils {
    private static final Logger log = LoggerFactory.getLogger(AllureUtils.class);

    public static void cleanAllureResults() {
        try {
            FileUtils.deleteQuietly(new File("test-output/allure-results"));
        } catch (Exception e) {
            System.out.println("Error in clean allure results");
        }
    }

    public static void attachScreenShots(String screenName, String screenPath) {
        try {
            Allure.addAttachment(screenName, newInputStream(Path.of(screenPath)));
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }

    public static void setAllureEnvironment() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("os", PropertyReader.getProperty("os.name"))
                        .put("JDK Version", PropertyReader.getProperty("java.runtime.version"))
                        .build(), PropertyReader.getProperty("user.dir") + File.separator + "test-output/allure-results" + File.separator
        );
    }
}
