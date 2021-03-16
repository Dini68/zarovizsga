package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WorkHours {

    public String minWork(String s) {
        String result = "";
        s = s.replace("test", "main");
        Path file = Path.of(s);
        try (BufferedReader reader = Files.newBufferedReader(Path.of(s))) {
            return getResult(reader);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private String getResult(BufferedReader reader) throws IOException {
        String line;
        int minHours = 24;
        String actName = "";
        String actDay = "";
        int actHours = 0;
        while((line = reader.readLine()) != null) {
            actHours = Integer.parseInt(line.split(",")[1]);
            if (actHours < minHours) {
                minHours = actHours;
                actName = line.split(",")[0];
                actDay = line.split(",")[2];
            }
        }
        return actName + ": " + actDay;
    }
}
