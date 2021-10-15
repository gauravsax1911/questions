import java.util.*;

public class twounique {

    // size of the hash table
    static int MAX_CHAR = 26;

  
    static void findAndPrintUncommonChars(String str1, String str2) {

        str1 = str1.replaceAll("\\s", "");
        str2 = str2.replaceAll("\\s", "");


        // mark presence of each character as 0
        // in the hash table 'present[]'

        int present[] = new int[MAX_CHAR];
        Arrays.fill(present, 0);

        int len1 = str1.length();
        int len2 = str2.length();

        // for each character of str1, mark its
        // presence as 1 in 'present[]'
        for (int i = 0; i < len1; i++) {
            present[str1.charAt(i) - 'A'] = 1;
        }

        // for each character of str2
        for (int i = 0; i < len2; i++) {

            // if a character of str2 is also present
            // in str1, then mark its presence as -1
            if (present[str2.charAt(i) - 'A'] == 1 || present[str2.charAt(i) - 'A'] == -1) {
                present[str2.charAt(i) - 'A'] = -1;
            }

            // else mark its presence as 2
            else {
                present[str2.charAt(i) - 'A'] = 2;
            }
        }

        // print all the unique characters 
        for (int i = 0; i < MAX_CHAR; i++) {
            if (present[i] == 1 || present[i] == 2) {
                System.out.print((char) (i + 'A') + " ");
            }
        }
    }

    
    public static void main(String[] args) {
        String str1 = "LOS ANGELESO";
        String str2 = "LAS VESGASV";
        findAndPrintUncommonChars(str1, str2);
    }

}