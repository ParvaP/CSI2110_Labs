 /*  CSI2114 Lab 3 - lab3.java
 *  
 *  Class to check balanced brackets in math expressions  
 *
 *  Usage: java bracketsBalance <exp>
 *  
 *  by Jeff Souza
 *
 */

class bracketsBalance {

    private boolean bBalance (String exp){ 
        int nRound = 0;
        int nCurl = 0;
        int nSquare = 0;
        boolean cRound = false;
        boolean cCurl = false;
        boolean cSquare = false;
        ArrayStack s = new ArrayStack(exp.length());
        char c;

        for (int i = 0; i<exp.length(); i++){
            s.push(exp.charAt(i));
        }
        while (s.isEmpty() == false){
            c = s.pop().toString().charAt(0);
            if (c == "(".charAt(0)){
                nRound++;
                if (!cRound){
                    return false;
                }
            } else if (c== ")".charAt(0)){
                nRound--;
                cRound = true;
            } else if (c == "[".charAt(0)){
                nSquare++;
                if (!cSquare){
                    return false;
                }
            } else if (c== "]".charAt(0)){
                nSquare--;
                cSquare = true;
            } else if (c == "{".charAt(0)){
                nCurl++;
                if (!cCurl){
                    return false;
                }
            } else if (c== "}".charAt(0)){
                nCurl--;
                cCurl = true;
            }
        }
        return nRound==0 && nCurl == 0 && nSquare == 0;

    }

    public static void main(String[] args) {

        bracketsBalance b = new bracketsBalance();
        boolean result = b.bBalance("{{[](())}[]}");
   
        if (result) System.out.println("The expression is balanced."); 
        else        System.out.println("The expression is NOT balanced."); 
    }
}