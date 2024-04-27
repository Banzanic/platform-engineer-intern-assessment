import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class RecordServiceTest {
    String projectRoot = System.getProperty("user.dir");
    RecordService recordService = new RecordService();

    @Test
    public void whenNewAuthorAndNewSong_thenExpectedValue() {
        //given
        Map<String, String> expectedMostPopularSongMap = new HashMap<>();
        Map<String, Map<String, Integer>> expectedSongLibraryMap = new HashMap<>();
        Map<String, Integer> innerMap = new HashMap<>();
        expectedMostPopularSongMap.put("Iron Maiden", "Rainmaker");
        innerMap.put("Rainmaker", 1);
        expectedSongLibraryMap.put("Iron Maiden", innerMap);

        //when
        recordService.record("Iron Maiden", "Rainmaker");

        //then
        Assert.assertEquals(recordService.getMostPopularSong(), expectedMostPopularSongMap);
        Assert.assertEquals(recordService.getSongLibrary(), expectedSongLibraryMap);
        Assert.assertEquals(recordService.top("Iron Maiden"), "Rainmaker");
    }

    @Test
    public void whenNewAuthorAndOldSong_thenExpectedValue() {
        //given
        Map<String, String> expectedMostPopularSongMap = new HashMap<>();
        Map<String, Map<String, Integer>> expectedSongLibraryMap = new HashMap<>();
        Map<String, Integer> innerMap = new HashMap<>();
        expectedMostPopularSongMap.put("Iron Maiden", "Rainmaker");
        expectedMostPopularSongMap.put("Traffic", "Rainmaker");
        innerMap.put("Rainmaker", 1);
        expectedSongLibraryMap.put("Iron Maiden", innerMap);
        expectedSongLibraryMap.put("Traffic", innerMap);

        //when
        recordService.record("Iron Maiden", "Rainmaker");
        recordService.record("Traffic", "Rainmaker");

        //then
        Assert.assertEquals(recordService.getMostPopularSong(), expectedMostPopularSongMap);
        Assert.assertEquals(recordService.getSongLibrary(), expectedSongLibraryMap);
        Assert.assertEquals(recordService.top("Iron Maiden"), "Rainmaker");
        Assert.assertEquals(recordService.top("Traffic"), "Rainmaker");
    }

    @Test
    public void whenOldAuthorAndNewSong_thenExpectedValue() {
        //given
        Map<String, String> expectedMostPopularSongMap = new HashMap<>();
        Map<String, Map<String, Integer>> expectedSongLibraryMap = new HashMap<>();
        Map<String, Integer> innerMap = new HashMap<>();
        expectedMostPopularSongMap.put("Iron Maiden", "Rainmaker");
        innerMap.put("Rainmaker", 1);
        innerMap.put("Out of the silent planet", 1);
        expectedSongLibraryMap.put("Iron Maiden", innerMap);

        //when
        recordService.record("Iron Maiden", "Rainmaker");
        recordService.record("Iron Maiden", "Out of the silent planet");

        //then
        Assert.assertEquals(recordService.getMostPopularSong(), expectedMostPopularSongMap);
        Assert.assertEquals(recordService.getSongLibrary(), expectedSongLibraryMap);
        Assert.assertEquals(recordService.top("Iron Maiden"), "Rainmaker");
    }

    @Test
    public void whenOldAuthorAndOldSong_thenExpectedValue() {
        //given
        Map<String, String> expectedMostPopularSongMap = new HashMap<>();
        Map<String, Map<String, Integer>> expectedSongLibraryMap = new HashMap<>();
        Map<String, Integer> innerMap = new HashMap<>();
        expectedMostPopularSongMap.put("Iron Maiden", "Rainmaker");
        innerMap.put("Rainmaker", 2);
        expectedSongLibraryMap.put("Iron Maiden", innerMap);

        //when
        recordService.record("Iron Maiden", "Rainmaker");
        recordService.record("Iron Maiden", "Rainmaker");

        //then
        Assert.assertEquals(recordService.getMostPopularSong(), expectedMostPopularSongMap);
        Assert.assertEquals(recordService.getSongLibrary(), expectedSongLibraryMap);
        Assert.assertEquals(recordService.top("Iron Maiden"), "Rainmaker");
    }

    @Test
    public void whenNewMostPopularSong_thenExpectedValue() {
        //given
        Map<String, String> expectedMostPopularSongMap = new HashMap<>();
        Map<String, Map<String, Integer>> expectedSongLibraryMap = new HashMap<>();
        Map<String, Integer> innerMap = new HashMap<>();
        expectedMostPopularSongMap.put("Iron Maiden", "Out of the silent planet");
        innerMap.put("Rainmaker", 1);
        innerMap.put("Out of the silent planet", 2);
        expectedSongLibraryMap.put("Iron Maiden", innerMap);

        //when
        recordService.record("Iron Maiden", "Rainmaker");
        recordService.record("Iron Maiden", "Out of the silent planet");
        recordService.record("Iron Maiden", "Out of the silent planet");

        //then
        Assert.assertEquals(recordService.getMostPopularSong(), expectedMostPopularSongMap);
        Assert.assertEquals(recordService.getSongLibrary(), expectedSongLibraryMap);
        Assert.assertEquals(recordService.top("Iron Maiden"), "Out of the silent planet");
    }

    @Test
    public void whenOldMostPopularSong_thenExpectedValue() {
        //given
        Map<String, String> expectedMostPopularSongMap = new HashMap<>();
        Map<String, Map<String, Integer>> expectedSongLibraryMap = new HashMap<>();
        Map<String, Integer> innerMap = new HashMap<>();
        expectedMostPopularSongMap.put("Iron Maiden", "Rainmaker");
        innerMap.put("Rainmaker", 1);
        innerMap.put("Out of the silent planet", 1);
        expectedSongLibraryMap.put("Iron Maiden", innerMap);

        //when
        recordService.record("Iron Maiden", "Rainmaker");
        recordService.record("Iron Maiden", "Out of the silent planet");

        //then
        Assert.assertEquals(recordService.getMostPopularSong(), expectedMostPopularSongMap);
        Assert.assertEquals(recordService.getSongLibrary(), expectedSongLibraryMap);
        Assert.assertEquals(recordService.top("Iron Maiden"), "Rainmaker");
    }

    @Test
    public void whenNoAuthor_thenNull() {
        //when
        String song = recordService.top("Iron Maiden");

        //then
        Assert.assertNull(recordService.top(song));
    }

    @Test
    public void whenFileEmpty_thenExpectedValue() throws IOException {
        //given
        Map<String, String> expectedMostPopularSongMap = new HashMap<>();
        Map<String, Map<String, Integer>> expectedSongLibraryMap = new HashMap<>();
        File expectedFile = new File(projectRoot + "/src/test/resources/emptyOutput.txt");

        //when
        recordService.read(Files.newBufferedReader(Paths.get(projectRoot + "/src/test/resources/emptyInput.txt")), Files.newBufferedWriter(Paths.get(projectRoot + "/src/test/resources/emptyOutput.txt")));

        //then
        Assert.assertEquals(recordService.getMostPopularSong(), expectedMostPopularSongMap);
        Assert.assertEquals(recordService.getSongLibrary(), expectedSongLibraryMap);
        Assert.assertEquals(expectedFile.length(), 0);
    }

}
