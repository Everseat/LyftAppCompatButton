# LyftAppCompatButton
A drop-in AppCompatButton for integrating with Lyft. This button conforms to the Lyft brand guidelines.

# Install
To add this library to your project, you must add the JitPack repo to your root build.gradle file...

```groovy
allprojects {
 repositories {
    ...
    maven { url "https://jitpack.io" }
 }
}
```

Then include this line in your dependencies block...

```
compile 'com.github.everseat:LyftAppCompatButton:0.1'
```

# Usage

```
<com.everseat.lyftappcompatbutton.LyftAppCompatButton
  android:layout_width="match_parent"
  android:layout_height="wrap_content"/>
```