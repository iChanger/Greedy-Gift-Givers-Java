/*
ID: ichangs1
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;

class gift1 {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
    BufferedReader lineRead = new BufferedReader(new FileReader("gift1.in"));
    
    int lines = 0;
    while (lineRead.readLine() != null) lines++;
    
    LinkedHashMap<String, Integer> people = new LinkedHashMap<String, Integer>(); //We use a LINKED hash map, because it maintains the ordering of the HashMap, unlike a regular Hashmap
    int initPeople = Integer.parseInt(f.readLine());                                             
    for( int i = 0; i < initPeople; i++){   
        String person = f.readLine();
        people.put(person, 0);
    }
    
    ArrayList<String> activity = new ArrayList<String>();
    for( int i = 0; i < lines - (initPeople + 1); i++){
       String line = f.readLine();
       activity.add(line);
     //  System.out.println(line);
    }
    
    
    for( int i = 0; i < activity.size(); i++){
        String giver = activity.get(i);
        StringTokenizer st = new StringTokenizer(activity.get(i + 1));
        int i1 = Integer.parseInt(st.nextToken());
        int i2 = Integer.parseInt(st.nextToken());
        people.put(giver, people.get(giver) - i1);
        if (i2 != 0){
            people.put(giver, people.get(giver) + (i1 % i2));
        }
        for( int a = i + 2; a < i + i2 + 2; a++){ //Retrieves all recipients
            String recipient = activity.get(a);
  
            if (i2 != 0){
                people.put(recipient, people.get(recipient) + i1/i2);
            }
        }
        
        i += (1 + i2); //Skip to the next double group of ints
    }
     
    
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));

    for (String key : people.keySet()){
        out.print(key + " ");
        out.println(people.get(key));
    }
 
    out.close();                                  // close the output file
  }
      
}
