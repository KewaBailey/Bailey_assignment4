import java.util.*;
import java.io.BufferedReader;

import java.io.BufferedWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.FileWriter;
import java.io.IOException;

public class DuplicateCounter {
	
	Map<String,Integer> wordCount = new HashMap<String,Integer>();

    public void remove(String dataFile) {

        File f1 = new File(dataFile);

        FileReader fr = null;

        BufferedReader br = null;

        try {

            fr = new FileReader(f1); //Creation of File Reader object

            String[] words = null;

            String input;

            br = new BufferedReader(fr); //Creation of BufferedReader object

            while ((input = br.readLine()) != null) //Reading Content from the file

            {

                input = input.replaceAll("[.,?!)(]", " "); //eliminate fullstops, commas, etc

                words = input.split("\\s+"); //Split the word using space, multiple spaces treated as one using regex

                for (String word : words) {
                	//{}
                	word = word.toLowerCase();
                	if(wordCount.get(word) == null) 
                	{
                		wordCount.put(word, 1);
                		
                	}
                	else 
                	{
                    	

                		wordCount.put(word, wordCount.get(word)+1);
                	}

                   // uniqueWords.add(word.toLowerCase()); //add word to set, set doesn't contain duplicate elements

                }

            }

        } catch (FileNotFoundException e) {

            System.out.println("File not found!");

        } catch (IOException e) {
        	System.out.println("Input/out expection");
        }
        finally {
        	System.out.println("Data read succesfully");
        }
        

            //close everything that's opened

           

                if (fr != null) {

                    try {
						fr.close();
					} catch (IOException e) {
			
						e.printStackTrace();
					}

                }

                if (br != null) {

                    try {
						br.close();
					} catch (IOException e) {
						
						e.printStackTrace();
					}}

                }

            

    

    public void write(String outputFile) {

        BufferedWriter bo = null;

        Iterator<String> itr = wordCount.keySet().iterator();

        try {

            bo = new BufferedWriter(new FileWriter(outputFile));

            while (itr.hasNext()) {
            	
            	String currentWord = itr.next().toString();

                bo.write( currentWord+ " : " + wordCount.get(currentWord));

                bo.newLine(); //write next word on a new line

            }
         

        }catch (NoSuchElementException e) {
        	System.out.print(e);

        } 
        catch (IOException e) {

        } 
        finally {

            try {

                if(bo!=null)

                    bo.close();

            } catch (IOException e) {

            }

        }

    }
			
}

