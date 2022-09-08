module com.udacity.catpoint.security{
    requires miglayout;
    requires java.desktop;
    requires java.prefs;
    requires guava;
    requires com.google.gson;
    requires com.udacity.catpoint.image;
    opens com.udacity.catpoint.security.data to com.google.gson;
}