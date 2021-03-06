import org.junit.BeforeClass;
import org.junit.Test;
import org.sonar.java.checks.DeadStoreCheck;
import org.sonar.java.checks.verifier.JavaCheckVerifier;
import org.sonar.java.se.checks.NullDereferenceCheck;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class ProcessorTest {

    private static String projectKey = "se.kth:sonatest";
    private static String cdtest ="./src/test/sonatest/";
    private static String pathToFile = cdtest + "src/main/java/";

    @Test
    public void DeadStore()throws Exception
    {
        String fileName = "DeadStores.java";
        String pathToRepairedFile = "./spooned/" + fileName;

        JavaCheckVerifier.verify(pathToFile + fileName, new DeadStoreCheck());
        TestHelp.repair(pathToFile,projectKey,1854);
        JavaCheckVerifier.verifyNoIssue(pathToRepairedFile, new DeadStoreCheck());
    }

    @Test
    public void NullDereference()throws Exception
    {
        String fileName = "NullDereferences.java";
        String pathToRepairedFile = "./spooned/" + fileName;

        JavaCheckVerifier.verify(pathToFile + fileName,new NullDereferenceCheck());
        TestHelp.repair(pathToFile,projectKey,2259);
        JavaCheckVerifier.verifyNoIssue(pathToRepairedFile, new NullDereferenceCheck());
    }

}