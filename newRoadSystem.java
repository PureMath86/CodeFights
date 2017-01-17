boolean newRoadSystem(boolean[][] roadRegister) {
    int [] incoming = new int [roadRegister.length];
    int [] outgoing = new int [roadRegister.length];
    for(int i = 0; i < roadRegister.length; i++) {
        for(int j = 0; j < roadRegister[0].length; j++) {
            if(roadRegister[i][j]) {
                outgoing[i]++;
                incoming[j]++;
            }
        }
    }
    for(int k = 0; k < incoming.length; k++) {
        if(incoming[k] != outgoing[k])
            return false;
    }
    return true;
}
