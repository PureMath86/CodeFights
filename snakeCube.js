
//I planned to make a clean, obvious version of this in Go.
//However, the CF checker can't check []byte correctly right now.
//I apologize to anyone reading this.


//Symbols to indicate direction
S = 'v<^>'
//Compare point a to n
E = s => s[0]==n[0] & s[1]==n[1]

snakeCube = (G, O) => {
    //Useful constants
    K = G.length
    N = K/3
    J = K+N
    L = --K-N

    //Advance from point p in direction D
    //Returns nothing, but sets
    // - n : the next point visited (r,c,dir)
    // - g : the row of G containing n
    // - c : n's column value
    A = p => {
        r = p[0]
        c = p[1]
        p = J+N-c-1

        //Being super hacky about if/else chains saves over 100 characters
        //This checks every condition of the snake crossing a cube edge
        // and returns the new point as [r,c,dir].
        //If the snake doesn't cross a cube edge, it returns 0, and [r,c,dir]
        // is given by the || at the end.
        n = (
            D>2 ? c++-L ? 0 : r<N ? [N, K-r] : r>L && [L, r, 2]
            : D>1 ? N-r-- ? r<0 && [N, p] : c<N ? [c, N, 3] : c>K ? [0, p] : c>L && [K-c, L, 1]
            : D ? N-c-- ? 0 : r<N ? [N, r] : r>L && [L, K-r, 2]
            : ++r-3*N ? r-2*N ? 0 : c>K ? [K, p, 2] : c>L ? [c, L, 1] : c<N && [K-c, N, 3] : [L, p, 2]
        ) || [r,(c+J)%J,D]
        g = G[n[0]]
        c = n[1]
    }

    //find the snake's head, remove it from the board,
    //set the starting direction to s
    for(r=s=-1; g=G[++r]; )
        for(c=0; s<0 && g[c]; o=[r,c])
            (s=S.indexOf(g[c]))+1 ? g[c]=U='_' : ++c

    //build the snake's body, 
    //removing it from the board as you go
    for(B=[]; o; )
        for(B.push(x=o), D=o=0; A(x), D<4; ++D)
            g[c]<U && (g[c]=U, o=n)
    
    //obey each order
    for(o of O) {
        //s is the previous direction
        //D is the new direction
        D = (s+(o>'F'?o<'Q'?3:1:0))%4
        //advance to the next point
        A(B[0])
        //move forward
        if(D==s) {
            //set and check the badness of the snake
            if(p=B.some(E))
                break
            D = ~~n[2]
            B = [n,...B]
            //clear an apple from the board
            //or move the tail one spot forward
            g[c]>U ? g[c]=U : B.pop()
        }
        //ignore turns into the body
        s = E(B[1]) ? s : D
    }

    //write the snake back onto the board
    for(n of B)
        G[n[0]][n[1]] = p ? 'x' : E(B[0]) ? S[D] : '*'

    return G
}

