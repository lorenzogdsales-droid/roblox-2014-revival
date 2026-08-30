# Roblox 2014 Revival ProGuard rules

# Keep all classes in our app package
-keep class com.roblox.revival2014.** { *; }

# Keep OkHttp classes
-keep class okhttp3.** { *; }
-keep class okio.** { *; }

# Keep Gson
-keep class com.google.gson.** { *; }
-keepclassmembers class * {
    @com.google.gson.annotations.SerializedName <fields>;
}

# Keep Android support libraries
-keep class androidx.** { *; }

# Remove logging in release
-assumenosideeffects class android.util.Log {
    public static *** d(...);
    public static *** v(...);
    public static *** i(...);
}
