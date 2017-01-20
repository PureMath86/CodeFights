public static String decode(String st)
{
    if (st == "" || st == null) return "";
    char[] A = st.toCharArray();
    char a = 0;
    StringBuffer sb = new StringBuffer();
    for (char s:A){
        if (!Character.isDigit(s)){
            a = s;
            sb.append(s);
        }
        else{
            int n = Integer.parseInt(String.valueOf(s));
            for (int i=0;i<n-1;i++){
                sb.append(a);
            }           
        }
    }
    return sb.toString();
}

int possibleRing(String s) {

int D = -1; // Number of Rings (possibly)

int C = 0;   // Carbons
int N = 0;   // Nitrogens
int O = 0;   // Oxygens
int H = 0;   // Hydrogens and Halogens

String r = Character.toString(s.charAt(0));    
int m = 0;
    
if(r.matches("\\d+") == true) {
    m = Integer.parseInt(r);
} else {m = 1;}    
    
String t = decode(s);

System.out.println(t);

int n = t.length(); // String length   

char c = 'a'; // character    

for(int i=0; i < n; i++) { 
    c = t.charAt(i);
    if( (c == 'C' && t.charAt(i+1) == 'l' ) || c == 'B' ) {
        H++;
        i++;
    } else if(c == 'C') {
        C++;
    } else if(c == 'N') {
        N++;
    } else if(c == 'O') {
        O++;
    } else { H++; }
}
    
if((N + H)*m % 2 == 1) { // Restriction 1 : DBE != fraction

    return D; // no rings can be formed : -1
    
} else { // Calculate DBE
    
    // Degree of Unsaturation : DBE (D)
    
    D = C + (N/2) - (H/2) + 1;
    
    D = D * m;
    
    //System.out.println(C);
    //System.out.println(N);
    //System.out.println(H);
    //System.out.println(D);

    if(D > m*(C + N + O - 2) || D <= 0) { // Restriction 2 : DBE !> C + N + O - 2
        
        return -1; // no rings can be formed : -1
    
    } else { return D;}
}

}



// ([A-Z][a-z]*)(\d*)    
    
/*
Pattern elementPattern = Pattern.compile("(\\p{Upper}\\p{Lower}?)(\\p{Digit}*)");
    
Matcher elementMatcher = elementPattern.matcher(s);
while (elementMatcher.find()) {
    String element = elementMatcher.group(1);
    String count = elementMatcher.group(2);
    System.out.println("Element: " + element + " count: " + count);
}    
*/    
    
    
/*    
try
    
{

int ca=Integer.parseInt(s);

System.out.println("I am Integer" +ca);

}
    

finally
    
{
    
c = Character.parseChar(s);

    
System.out.println("I am Character" +c);
    
}
 */   

    
/*
catch(Exception e)

{

System.out.println("Exception is "+e);

}

SEE: http://omega.cs.iit.edu/~bharatkris/blog/?p=54
*/  
 
    
