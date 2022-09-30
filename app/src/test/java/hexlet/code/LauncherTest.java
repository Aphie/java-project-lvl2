package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class LauncherTest {
    @Test
    void launcherTestRelativePath() throws Exception {
        String filePath = "src/test/resources/launcherTest/launcherTestPath.json";

        String expected = new File("src/test/resources/launcherTest/launcherTestPath.json").getAbsolutePath();
        Assertions.assertEquals(expected, Launcher.checkAndConvertPaths(filePath));
    }

//    @Test
//    void launcherTestAbsolutePath() throws Exception {
//        String filePath =
//                "C:\\Users\\s.andreyuk\\IdeaProjects\\app\\src\\test\\resources\\launcherTest\\launcherTestPath.json";
//
//        String expected = new File("src/test/resources/launcherTest/launcherTestPath.json").getAbsolutePath();
//        Assertions.assertEquals(expected, Launcher.checkAndConvertPaths(filePath));
//    }

}
