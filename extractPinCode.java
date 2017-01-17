int[] extractPinCode(double[] c) {
  
int n = c.length;
double sy = c[n-2];
double sx = c[n-1];
int x = 0;
int y = 0;
 
List<Integer> b = new LinkedList<Integer>(); // List of button presses
    
    for(int i = 0; i < n/2; i++) {
        c[2*i] = Math.rint((sy - c[2*i]) / 2);
        c[2*i+1] = Math.rint((c[2*i+1] - sx) / 2);
        x = (int) c[2*i+1];
        y = (int) c[2*i];

    // build answer: a
        // build button sequence: b
        
        if(y == 0) { // bottom row
            if(x == 2) { // right column
                b.remove(b.size() - 1); // delete last button     
            } else if (x == 0) { // left column
                System.out.println(b); // Submit
            } else { // middle column
                b.add(0);
            }
        } else if(y == 3) { // top row
            if(x == 0) { // left column
                b.add(1);
            } else if (x == 1) { // middle column
                b.add(2);
            } else { // right column
                b.add(3);
            }
        } else if(y == 2) { // 2nd from top row
            if(x == 0) { // left column
                b.add(4);
            } else if (x == 1) { // middle column
                b.add(5);
            } else { // right column
                b.add(6);
            }
        } else { // 2nd from bottom row
            if(x == 0) { // left column
                b.add(7);
            } else if (x == 1) { // middle column
                b.add(8);
            } else { // right column
                b.add(9);
            }
        }
    }

int[] a = new int[4];
for(int i = 0; i < 4; i++) a[i] = b.get(i);
    return a;
}
