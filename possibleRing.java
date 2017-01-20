int c,n,h,o,m,p,i;
int possibleRing(String f) {
    f=f.replaceAll("(Cl|F|Br|I)","H");
    for(i=0;i<f.length();i++){
        m=f.charAt(i);
        if(m<'A') continue;
        p=0;
        while(i<f.length()-1 && f.charAt(i+1)<'A')
            p=p*10+f.charAt(++i)-'0';
        
        p=p<1?1:p;
        if(m=='C') c+=p;
        if(m=='H') h+=p;
        if(m=='N') n+=p;
        if(m=='O') o+=p;
    }
    int d=c+n/2-h/2+1;
    if( d<1 || (n+h)%2>0) return -1;
    return Math.min(d,c+n+o-2);
