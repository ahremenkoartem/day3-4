package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RepeatedWordReader {
    final String filename;

    public RepeatedWordReader(String filename) {
        this.filename = filename;
    }
    public void count(){
        try(final BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String currentLine;
            String mostRepeatedWord = null;
            final HashMap<String,Integer> wordCountMap = new HashMap<>();
            int count = 0;
            int tempCount = 0;
            while ((currentLine=reader.readLine())!=null){
                String[] words = currentLine.toLowerCase().split("[.,;:\\s]");
                for(String word: words){
                    if(word.length()==0){
                        continue;
                    }
                    tempCount = wordCountMap.containsKey(word)?wordCountMap.get(word)+1:1;
                    if(tempCount>count){
                        count=tempCount;
                        mostRepeatedWord =word;
                    }
                    wordCountMap.put(word,tempCount);
                }
            }
            final Set<Map.Entry<String, Integer>> entrySet = wordCountMap.entrySet();
            System.out.println("The most repeated word in input file is: "+mostRepeatedWord);

            System.out.println("Number of occurences :"+ count);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
