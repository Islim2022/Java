import java.util.HashMap;
import java.util.Set;

public class MapOfHashmatique{
    public static void main(String[] args){
        HashMap<String, String> songList = new HashMap<String, String>();
        songList.put("Purple Sun", "Stuck inside a dream, Floating down a stream with you.");
        songList.put("Heat Waves", "I'm swimmin' in a mirror Road shimmer wigglin' the vision");
        songList.put("Fire on fire", "Fire on fire, would normally kill us");
        songList.put("Bad Dream", "I couldn't think of the right words, Now it's just too late");

        String song1 = songList.get("Purple Sun");
        System.out.println("Lyrics for the first song are: " + song1);

        Set<String> lyrics = songList.keySet();
        for(String Track: lyrics) {
            System.out.println(Track);
            System.out.println(songList.get(Track));    
        }
    }
}