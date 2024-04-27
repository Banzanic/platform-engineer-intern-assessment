import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RecordService {
    private final Map<String, String> mostPopularSong = new HashMap<>();
    private final Map<String, Map<String, Integer>> songLibrary = new HashMap<>();

    public void read(BufferedReader inputReader, BufferedWriter outputWriter) throws IOException {
        String line;
        while ((line = inputReader.readLine()) != null) {
            String[] commandSplitter = line.split(":", 2);
            String command = commandSplitter[0];
            if ("record".equals(command)) {
                String[] parameterSplitter = commandSplitter[1].split(",");
                String author = parameterSplitter[0];
                String songName = parameterSplitter[1];
                record(author, songName);
            } else if ("top".equals(command)) {
                String author = commandSplitter[1];
                if (top(author) != null) {
                    outputWriter.write(author + ":" + top(author));
                    outputWriter.newLine();
                }

            }
        }
        outputWriter.close();
    }

    public void record(String author, String songName) {
        songLibrary.putIfAbsent(author, new HashMap<>());
        Map<String, Integer> songCounter = songLibrary.get(author);
        addSong(songCounter, songName);
        updateMostPopularSong(songCounter, author, songName);
    }

    private void addSong(Map<String, Integer> songCounter, String songName){
        songCounter.put(songName, (songCounter.getOrDefault(songName, 0) + 1));
    }

    private void updateMostPopularSong(Map<String, Integer> songs, String author, String songName){
        if (mostPopularSong.get(author) == null || songs.get(songName) > songs.get(mostPopularSong.get(author))) {
            mostPopularSong.put(author, songName);
        }
    }

    public String top(String author) {
        return mostPopularSong.get(author);
    }

    public Map<String, String> getMostPopularSong() {
        return mostPopularSong;
    }

    public Map<String, Map<String, Integer>> getSongLibrary() {
        return songLibrary;
    }
}
