String friendly_numbers(int x, int y) {
    String ret = "No";
    
    int counterX = 0, counterY = 0;
    int length = 0;
    
    if(x >= y){
        length = x;
    } else {
        length = y;
    }
    
    for(int i=1; i<length; i++){
        if(i < x){
            if(x % i == 0){
                counterX += i;
            }
        }
        if(i < y){
            if(y % i == 0){
                counterY += i;
            }
        }
    }
    
    if(counterX == y && counterY == x && x != y){
        ret = "Yes";
    }
    
    return ret;
}
