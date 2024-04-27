import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class AppRunner {
    public static void main(String[] args) throws IOException {
        String projectRoot = System.getProperty("user.dir");
        RecordService recordService = new RecordService();
        recordService.read(Files.newBufferedReader(Paths.get(projectRoot + "/input.txt")), Files.newBufferedWriter(Paths.get(projectRoot + "/output.txt")));
    }
}
