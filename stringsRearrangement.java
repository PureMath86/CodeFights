boolean stringsRearrangement(String[] s) {

int n = s.length;    
int[][] m = new int[n][n];    
int N = s[1].length();
int c = 0;
    
    // Adjacency ("Distance" between words) Matrix
    for(int i=0; i < n; i++) {
        for(int j=0; j < n; j++) {
            c = 0;
            for(int k=0; k < N; k++) {
                if(s[i].charAt(k) != s[j].charAt(k)) {
                    c++;
                }
            }
            m[i][j] = c;
        }
    }
    
    // Convert to true adjacency matrix
    for(int i=0; i < n; i++) {
        for(int j=0; j < n; j++) { 
            if (m[i][j] != 1) {m[i][j] = 0;}
        }
    }

boolean b = true;

/*    
int[] M = new int[n];
c = 0;    
   
    // Valence Array
    for (int i = 0; i < n; i++) {
        c = 0;
        for (int j : m[i]) {
            c += j;
        }
        M[i]=c;
    }

c = 0;
    
    // Count Zero Valences
    for(int i=0; i < n; i++) {
        if(M[i] == 0) {
            c++;
        }
    }
    
    // Check Zero Valences
    if (c >= 1){
        b = false;
        return b;
    }
    
c = 0;
    
    // Count Single Valences
    for(int i=0; i < n; i++) {
        if(M[i] == 1) {
            c++;
        }
    }
    
    // Check Single Valences
    if (c >= 3){
        b = false;
        return b;
    }
*/

List<Integer> q = new LinkedList<Integer>();
q.add(0);
int a = 0;
c = 0;
    
    // Try to build a Hamiltonian Path
    for(int i=1; i < n; i++) {
        a = q.get(0); // first vertex (in q)
        c = q.get(q.size()-1); // last vertex (in q)
        if(m[c][i] == 1) {
            q.add(i);
        } else if(m[a][i] == 1) {
            Collections.reverse(q);
            q.add(i);
            Collections.reverse(q);
        }
    }
        
if(q.size() != n) {b = false;}
    
return b;
}

