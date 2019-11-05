<h1>library internet time for bangladesh religion</h1>

//add this build.gradle [project module]

allprojects {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
}


//use this dependency 

implementation 'com.github.mdmasum-shuvo:internet_provide_time:0.0.1'

// implement this in your activity class 
    DateTimeChangeCallback
//call constuctor on your activity
  Clock clock=new clock(this,this)
