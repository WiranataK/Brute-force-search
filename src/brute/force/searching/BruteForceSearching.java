/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brute.force.searching;

/**
 *
 * @author WKMachine2
 */
public class BruteForceSearching {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(search("This is Brute-force", "Searching"));
    }
    
    public static int search(String text, String pattern){
        int lengthOfPattern = pattern.length();
        int lengthOfText = text.length();
        
        for (int i = 0; i <= lengthOfText - lengthOfPattern; i++){
            int j;
            for (j = 0; j < lengthOfPattern; j++){
                if (text.charAt(i + j) != pattern.charAt(j))
                    break;
            }
            if (j == lengthOfPattern)
                return i;
        }
        return lengthOfText;
    }
}
