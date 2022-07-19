// --== CS400 Project One File Header ==--
// Name: FNU Simran
// Email: simran4@wisc.edu
// Team: Red
// Group: DQ
// TA: Yuye J
// Lecturer: Florian Heimerl

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

// interface (implemented with proposal)

interface SearchBackEndInterface {
    public void addSong(SongDataInterface song);
    public boolean containsSong(SongDataInterface song);

    // returns list of the titles of all songs that contain the word titleWord in their song title
    public List<String> findTitles(String titleWord);

    // returns list of the artists of all songs that contain the word titleWord in their song title
    public List<String> findArtists(String titleWord);

    // returns the number of songs that contain the word titleWord in their song title, and were published in year
    public int findNumberOfSongsInYear(String titleWord, int year);
}

// public class (implemented primarilly in final app week)

public class SearchBackEnd implements SearchBackEndInterface {

    HashtableMap<String,List<SongDataInterface>> songDataMap =new HashtableMap();

    //constructor for initialization of tableSongData

    @Override
    public void addSong(SongDataInterface song) {
        // TODO Auto-generated method stub

        String title = song.getTitle();
        String[] words = title.split("");

        //put key->word, value->song interface
        for(String word : words){
            if(songDataMap.containsKey(word))
                songDataMap.put(word, new ArrayList<>());
            songDataMap.get(word).add(song);
        }//end of for
    }//end of addSong

    @Override
    public boolean containsSong(SongDataInterface song) {
        // TODO Auto-generated method stub

        String title = song.getTitle();
        String[]words = title.split("");

        for(String word : words){

            if(songDataMap.containsKey(word)){

                List<SongDataInterface> songList = songDataMap.get(word);

                for(SongDataInterface s : songList){
                    if(s.equals(song))
                        return true;
                }//end of for

            }//end of if

        }//end of for
        return false;
    }//end of containsKey

    @Override
    public List<String> findTitles(String titleWord) {
        // TODO Auto-generated method stub

        List<String> titlesList = new ArrayList<>();
        String[] words = titleWord.split("");

        for(String word : words){

            if(songDataMap.containsKey(word)){

                List<SongDataInterface> songList = songDataMap.get(word);

                for(SongDataInterface s : songList)
                    titlesList.add(s.getTitle());
            }//end of if
        }//end of for

        return titlesList;

    }//end of findTitles()

    @Override
    public List<String> findArtists(String titleWord) {
        // TODO Auto-generated method stub

        List<String> artistsList = new ArrayList<>();
        String[] words = titleWord.split("");

        for(String word : words){
            if(songDataMap.containsKey(word)){

                List<SongDataInterface> songList = songDataMap.get(word);

                for(SongDataInterface s : songList){
                    if(!artistsList.contains(s.getArtist()))
                        artistsList.add(s.getArtist());
                }//end of for
            }//end of if
        }//end of for

        return artistsList;
    }//end of findArtists()

    @Override
    public int findNumberOfSongsInYear(String titleWord, int year) {
        int counter = 0;
        String[] words = titleWord.split("");

        for(String word : words){

            if(songDataMap.containsKey(word)){

                List<SongDataInterface> songList = songDataMap.get(word);

                for(SongDataInterface s : songList){

                    if(s.getYearPublished() == year)
                        counter++;

                }//end of for
            }//end of if
        }//end of for

        return counter;

    }//end of findNumberOfSongsInYear()
}
