friendly_numbers = (x, y)=>{
    return (s(x) == s(y) & x!=y)?"Yes":"No";
}

s = (n)=>{
    t=0;
    for(i =1;i<Math.sqrt(n);i++){
        t+=(n%i)?0:(n/i) + i;
    }
    return t;
}
