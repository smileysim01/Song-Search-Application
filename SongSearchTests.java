import java.util.ArrayList;
import java.util.List;

public class SongSearchTests {

    public static void main(String[] args) throws Exception {

        SongSearchTests BackEndObject = new SongSearchTests();
        System.out.println(BackEndObject.test1());
        System.out.println(BackEndObject.test2());
        System.out.println(BackEndObject.test3());

        // Run All Tests
    }

    // Data Wrangler Code Tests

    // Back End Developer Tests
    public boolean test1(){

        SearchBackEnd test1 = new SearchBackEnd();
        SongData song = new SongData("Sexy Bitch (feat. Akon)","David Guetta",2010);
        test1.addSong(song);
        if(test1.containsSong(song))
            return true;
        return false;

    }

    public boolean test2(){

        SearchBackEnd test2 = new SearchBackEnd();
        SongData song = new SongData("Sexy Bitch (feat. Akon)","David Guetta",2010);
        test2.addSong(song);
        List<String> titlesList = new ArrayList<>();
        titlesList.add("Sexy Bitch (feat. Akon)");
        if(test2.findTitles("Sexy Bitch (feat. Akon)").equals(titlesList))
            return true;
        return false;
    }

    public boolean test3(){

        SearchBackEnd test3 = new SearchBackEnd();
        SongData song = new SongData("Sexy Bitch (feat. Akon)","David Guetta",2010);
        test3.addSong(song);
        List<String> artistsList = new ArrayList<>();
        artistsList.add("David Guetta");
        if(test3.findArtists("David Guetta").equals(artistsList))
            return true;
        return false;

    }

//    public boolean static test4(){
//
//        SearchBackEnd test4 = new SearchBackEnd();
//        SongData song = new SongData("Sexy Bitch (feat. Akon)","David Guetta",2010);
//        test4.addSong(song);
//        List<String> artistsList = new ArrayList<>();
//        artistsList.add("David Guetta");
//        if(test4.findArtists("David Guetta").equals(artistsList))
//            return true;
//        return false;
//
//    }


    // Front End Developer Tests

    // Integration Manager Tests


}