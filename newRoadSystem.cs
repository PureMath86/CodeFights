bool newRoadSystem(bool[][] roadRegister) {
    int x = 0;
    int columns = roadRegister.GetLength(0);
    for(int n = 0; n<columns; n++){
        for(int i = 0; i<columns; i++){
            if(roadRegister[n][i]) x++;
            if(roadRegister[i][n]) x--;
        }
        if(x!=0) return false;
    }
    
    return true;
}

