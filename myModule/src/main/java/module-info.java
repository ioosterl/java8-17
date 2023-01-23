module myModule {
//    requires somemodulename;
//    requires static modulename;  // optional dependency. Only required  at compile time, not necessarily at run time
//    requires transitive amodulename; // make sure a depending module also includes this dependency
//    provides interfacename with implemenationname; // declare a service is being provided
//    uses intefacename; // indicate a certain service is needed
    exports package1;
}