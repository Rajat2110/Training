import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PlayerScores {
    public static void main(String[] args) {
        Map<String, Integer> highestScores = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("Scores.csv")); //read the csv file
            String line;
            while((line=br.readLine())!=null){
                String[] data = line.split(",");
                String pName = data[0]; //get player name

                for(int i=1; i<5; i++){
                    String scoreData = data[i];

                    //get score from the string
                    int score = 0;
                    String[] scores = scoreData.split("_");
                    score = Integer.parseInt(scores[1]);

                    //update the scores
                    highestScores.put(pName, Math.max(highestScores.getOrDefault(pName, 0),score));
                }
            }br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(Map.Entry<String, Integer> entry: highestScores.entrySet()){
            System.out.println("Player: "+ entry.getKey() + " Highest score: " + entry.getValue());
        }
    }
}
