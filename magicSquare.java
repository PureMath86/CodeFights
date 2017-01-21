int[][] magicSquare(int b, int s, int n) {
        return n < 2 ? new int[][]{{b}} : n > 2 ? n > 3 ? new int[][]
            {{b, b+s, b+14*s, b+15*s},
             {b+11*s, b+13*s, b+2*s,  b+4*s},
             {b+12*s, b+6*s,  b+9*s,  b+3*s},
             {b+7*s,  b+10*s, b+5*s,  b+8*s}
             } : new int[][]
             {
                     {b+s,    b+6*s, b+5*s},
                     {b+8*s,  b+4*s, b},
                     {b+3*s,  b+2*s, b+7*s}
             } : new int[][]{};

}

