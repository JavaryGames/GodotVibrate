#GodotVibrate
Vibration support on Godot engine for Android.

Godot version 2.0 stable.

##How to use
Drop the vibrate folder inside godot/modules

Move the vibrate/GodotVibrate.java to godot/platform/android/java/src/org/godotengine/godot

###Compile
1. #> scons platform=android
2. cd godot/platform/android/java
3. #> ./gradlew build
4. The resulting apk will be available at godot/platform/android/java/build/outputs/apk
 
###Configure
Add the following in the engine.cfg file:

> [android]

> modules="org/godotengine/godot/GodotVibrate"

**Use them in the script:**

> var singleton = Globals.get_singleton("GodotVibrate")

> singleton.doVibrate(200) # milliseconds

###Build the game apk
From the settings of the godot engine UI:

> Export->Target->Android


Custom Package (Debug/Release): 
> Point to the newly built apk

> Permission check: Vibrate

Enjoy!!

