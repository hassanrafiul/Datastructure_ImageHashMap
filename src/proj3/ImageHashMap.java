package proj3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author rafiu
 */
public class ImageHashMap {

    public static HashMap<String, ArrayList<String>> imageSearch = new HashMap<>();

    public static void main(String args[]) {

        imageSearch.put("animals", new ArrayList<>());
        imageSearch.put("people", new ArrayList<>());
        imageSearch.put("flowers", new ArrayList<>());
        imageSearch.put("buildings", new ArrayList<>());
        imageSearch.put("landscapes", new ArrayList<>());

        String file, keywords;

        try {
            Scanner inFile = new Scanner(new File("imageList.txt"));
            while (inFile.hasNext()) {
                file = inFile.next();
                keywords = inFile.nextLine();

                if (keywords.contains("animals")) {
                    imageSearch.get("animals").add(file);
                }
                if (keywords.contains("people")) {
                    imageSearch.get("people").add(file);
                }
                if (keywords.contains("flowers")) {
                    imageSearch.get("flowers").add(file);
                }
                if (keywords.contains("buildings")) {
                    imageSearch.get("buildings").add(file);
                }
                if (keywords.contains("landscapes")) {
                    imageSearch.get("landscapes").add(file);
                }
            }

            inFile.close();

        } catch (FileNotFoundException e) {

            System.out.println(e + "");

        }

        Scanner scan = new Scanner(System.in);

        while (true) {

            System.out.println("What would you like to search for? ");

            String inputLine = scan.nextLine();
            System.out.println();

            ArrayList<String> list = new ArrayList();

            for (String value : imageSearch.get(inputLine.toLowerCase())) {
                list.add(value);
            }

            if (list == null || list.isEmpty()) {

                System.out.println("No Input Result corresponding to the Object.");

            } else {

                for (String iteratorSt : list) {
                    System.out.println(iteratorSt);
                }

            }

            System.out.println("\nWould you like to exit(yes/no)? ");

            String input = scan.nextLine();
            System.out.println();

            if (input.equalsIgnoreCase("yes")) {

                break;

            } else if (input.equalsIgnoreCase("no")) {

                while (true) {
                    
                    System.out.println();
                    System.out.println("What would you like to search for? ");

                    inputLine = scan.nextLine();
                    System.out.println();

                    ArrayList<String> list2 = new ArrayList();

                    for (String value : imageSearch.get(inputLine.toLowerCase())) {
                        list2.add(value);
                    }

                    if (list2 == null || list2.isEmpty()) {

                        System.out.println("No Input Result corresponding to the Object.");

                    } else {

                        for (String iteratorSt : list2) {
                            System.out.println(iteratorSt);
                        }
                        System.out.println();
                        break;

                    }
                    
                }
            }
        }
        scan.close();
    }
}
// the project is not finished. i tried the input filed with (and or values)
// i tried my best with hasmap but might not be the good ones you would usually see