<h2>library internet time of bangladesh region</h2>

//add this build.gradle [project module] </br>

allprojects {</br>
    repositories {</br>
        jcenter()</br>
        maven { url "https://jitpack.io" }</br>
    }</br>
}


//use this dependency</br> 

implementation 'com.github.mdmasum-shuvo:internet_provide_time:0.0.1'</br>

// implement this in your activity class </br>
    DateTimeChangeCallback </br>
//call constuctor on your activity </br>
  Clock clock=new clock(this,this)
