function newRoadSystem(roadRegister) {
    var cities = new Array(roadRegister.length);
    for(var i = 0; i < cities.length; i++) {
        cities[i] = new City(roadRegister[i]);
    }
    
    cities.forEach(function(city) {
       for(var i = 0; i < city.register.length; i++) {
           if(city.register[i]) {
               city.out++;
               cities[i].in++;
           }
       } 
    });
    
    for(var i = 0; i < cities.length; i++) {
        if(cities[i].in != cities[i].out) {
            return false;
        }
    }
    
    return true;
}

function City(register) {
    this.register = register;
    this.in = 0;
    this.out = 0;
}
