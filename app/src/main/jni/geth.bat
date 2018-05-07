set ANDROID_CLASSPATH="D:\android-sdk-windows\platforms\android-26\android.jar"
set JNI=space.bestysh.scanner.Scanner



set JNI_JAVA="%JNI:.=\%.java"
set JNI_CLASS="%JNI_JAVA:java=class%"

cd ../java/
echo %JNI_JAVA%
javac -classpath %ANDROID_CLASSPATH%;. -h . %JNI_JAVA%
del %JNI_CLASS%
move *.h ../jni/
cd ../jni/
pause