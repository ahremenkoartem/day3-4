package main.java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class RepeatedWordReader {
    final String filename;

    public RepeatedWordReader(String filename) {
        this.filename = filename;
    }
    @SuppressWarnings("unchecked")
    public void count() {
        try(final BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String currentLine;
            int character;
            StringBuffer sb = new StringBuffer();
            String mostRepeatedWord = null;
            final Map<String,Integer> wordCountMap = new HashMap<>();

            int count = 0;
            int tempCount = 0;
            while ((character=reader.read())!=-1){
//                String[] words = currentLine.toLowerCase().split("[.,;:\\s]");

                if(((char) character) != ' ' && ((char) character) != '.' && ((char) character) != ';'
                        &&((char) character) != ':' &&
                        character != 10 && character != 13){
                    sb.append((char)character);
                    continue;
                }
                String word = sb.toString().toLowerCase();

                sb.delete(0,sb.length());
//                sb.append(character);
//                for(String word: words){
                    if(word.length()==0){
                        continue;
                    }
                    tempCount = wordCountMap.containsKey(word)?wordCountMap.get(word)+1:1;
                    if(tempCount>count){
                        count=tempCount;
                    }
                    wordCountMap.put(word,tempCount);
                }
            final  Set<Map.Entry<String,Integer>> entries = wordCountMap.entrySet();
            final List<Map.Entry<String,Integer>> sortedList = new ArrayList<>(wordCountMap.entrySet());
        sortedList.sort(new Comparator<Map.Entry<String,Integer>>() {
                @Override
                public int compare(Map.Entry<String,Integer> o1,Map.Entry<String,Integer> o2){
                    return (o2.getValue()).compareTo(o1.getValue());
                }
            });
            for (Map.Entry<String,Integer> entry: sortedList){
                if (entry.getValue()>=count){
                    System.out.println("The most repeated word in input file is: "+entry.getKey());
                    break;
                }
            }
            System.out.println("Number of occurences :"+ count);
        }catch (IOException e){}
    }
}
