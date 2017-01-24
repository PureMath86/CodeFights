String friendly_numbers(int x, int y) {

String s = "No";    
    
int X = (int)Math.sqrt(x); // x upper bound
int sx=1; // initialize the sum

int Y = (int)Math.sqrt(y); // y upper bound
int sy=1; // initialize the sum

    // Sum of Divisors of x : sx
    for(int i = 2; i <= X; i++)
    {
        if(x % i == 0)
        {
           sx += i;
           int d = x/i;
           if(d!=i)
              sx+=d;
        }
    }
    
    // Sum of Divisors of y : sy
    for(int i = 2; i <= Y; i++)
    {
        if(y % i == 0)
        {
           sy += i;
           int d = y/i;
           if(d!=i)
              sy+=d;
        }
    }
    
if (sx == y && sy == x && x != y) {s = "Yes";}
    
return s;     
}
