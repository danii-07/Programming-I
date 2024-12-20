
public class hearts

{  
    // first we start the main() method
    // the string thingy allows the program to accept command-line arguments, but it’s not used here 
    public static void main(String[] args)  
    {  
            // then we declare and initialize variable for output size, so basically determines the overall size of the heart
            final int size = 4  ; 

        // this outer loop repeats through the rows of the upper part of the heart. it will run size times (4 times in this case).
        for (int m = 0; m < size; m++) {  

            // now this is a nested loop, which is an inner loop that runs for each column in a wide section (5 times size, which equals 20 columns).
            for (int n = 0; n <= 4 * size; n++) {  

                // these two double calculate the distance from points (m, n) to two centers of the heart using the distance formula. 
                double leftheartie = Math.sqrt(Math.pow(m - size, 2) + Math.pow(n - size, 2)); 
                double rightheartie = Math.sqrt(Math.pow(m - size, 2) + Math.pow(n - 3 * size, 2));  
   
                // this checks if the point is within the heart shape (the condition is true), it prints a star (*), and if it is outside, prints a space ( ).
                if (leftheartie < size + 0.5 || rightheartie < size + 0.5) {  // this line checks if the point is close to the left or right part of the heart.
                        System.out.print("\u001b[31m*\u001b[0m");  // this is an ANSI escape code, which are a series of characters that can be used to control the formatting of text in a terminal.
                } else {  
                        System.out.print(' ');  
                } 
            }  
            System.out.print(System.lineSeparator());  //this just moves the little * to the next line
    }  
    // printing the lower part of heart, again iterating through a number of rows that depend on size.
    for (int m = 1; m <= 2 * size; m++)  
    {  
        for (int n = 0; n < m; n++) {  // first inner loopie, which prints leading spaces to properly align the heart.
            System.out.print(' ');  
    }  
    for (int n = 0; n < 4 * size + 1 - 2 * m; n++) {  // this second inner loopie prints * decreasing the number printed as m increases, forming the triangular lower part of the heart.
            System.out.print("\u001b[31m*\u001b[0m");  // this part " \u001b[31m "" sets the text color to red ---- then this part " * " is just the character ---- finally this part " \u001b[0m "resets the text formatting to default.
        }  
    System.out.print(System.lineSeparator());  
}  
}  
}   
                 
