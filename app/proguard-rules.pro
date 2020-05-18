# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-verbose
-printmapping proguardMapping.txt

# * 不忽略非公共的库的类的成员
-dontskipnonpubliclibraryclassmembers

# * 抛出异常时保留代码行号
-keepattributes SourceFile, LineNumberTable
-keep class com.create.userqr.bean.**
-keep class com.create.userqr.bean.**{*;}
-keep class com.uoii.think.bean.**
-keep class com.uoii.think.bean.**{*;}
-keep class com.uoii.think.http.HttpException
-keep class com.uoii.think.http.HttpException{*;}

-keepattributes Signature

-dontwarn javax.annotation.Nullable
-dontwarn com.google.**
-keep class javax.annotation.** { *; }
-dontwarn javax.annotation.**

-keepclasseswithmembernames class * {
    native <methods>;
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# 保留 Serializable 序列化的类不被混淆
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

# 不混淆 R 资源下的所有类及方法
-keep class **.R$* {
 *;
}

# 对带有回调函数 onXXEvent， 不混淆该方法
-keepclassmembers class * {
    void *(**On*Event);
}

-keep public class * extends android.view.View {
    *** get*();
    void set*(***);
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

# OKHTTP
-dontwarn com.squareup.okhttp.**
-keep class com.squareup.okhttp.** { *;}
-dontwarn okio.**

# retrofit2
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions

# rxjava
-dontwarn sun.misc.**
-keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
 long producerIndex;
 long consumerIndex;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
 rx.internal.util.atomic.LinkedQueueNode producerNode;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueConsumerNodeRef {
 rx.internal.util.atomic.LinkedQueueNode consumerNode;
}

-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public class * extends com.bumptech.glide.module.AppGlideModule
-keep public enum com.bumptech.glide.load.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}

-dontwarn com.bumptech.glide.load.resource.bitmap.VideoDecoder

-keep class * extends com.raizlabs.android.dbflow.config.DatabaseHolder { *; }

#eventbus
-keepattributes *Annotation*
-keepclassmembers class ** {
    @org.greenrobot.eventbus.Subscribe <methods>;
}
-keep enum org.greenrobot.eventbus.ThreadMode { *; }

# Only required if you use AsyncExecutor
-keepclassmembers class * extends org.greenrobot.eventbus.util.ThrowableFailureEvent {
    <init>(java.lang.Throwable);
}

# fastjson
-keep  class com.alibaba.fastjson.**{ *;}
-dontwarn com.alibaba.fastjson.**
-dontskipnonpubliclibraryclassmembers
-dontskipnonpubliclibraryclasses
-keep class * implements java.io.Serializable { *; }

#retrofit
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions

#okhttp
-dontwarn okhttp3.**
-keep class okhttp3.**{*;}
-keep interface okhttp3.**{*;}

-dontwarn com.gpower.billing.provider.**
-dontwarn com.google.gson.**
-keep class com.gpower.billing.provider.** {*;}
-keep class com.google.gson.** {*;}

-keepattributes *Annotation*,EnclosingMethod
-keep public class org.simpleframework.**{ *; }
-keep public class org.simpleframework.xml.**{ *; }
-keep public class org.simpleframework.xml.core.**{ *; }
-keep public class org.simpleframework.xml.util.**{ *; }
-keep public class org.simpleframework.xml.stream.**{ *; }
-keep public class javax.** { *; }
-keep public class javax.xml.stream.**{ *; }
-keep public class org.simpleframework.** {
  public void set*(***);
  public *** get*();
}

# don't obfuscate Jackson classes
-keep class com.fasterxml.** { *; }

# don't strip runtime annotations
-keepattributes RuntimeVisibleAnnotations


-keepclassmembers class * {
     @com.fasterxml.jackson.annotation.JsonCreator *;
     @com.fasterxml.jackson.annotation.JsonProperty *;
}

-keep class com.instlikebase.component.BadgeActionProvider

-dontwarn okhttp3.logging.**
-dontwarn info.guardianproject.netcipher.client.**
-dontwarn org.greenrobot.greendao.**
-dontwarn com.fasterxml.jackson.**
-dontwarn retrofit2.Platform$Java8
-dontwarn com.paypal.android.sdk.**
-dontwarn com.squareup.picasso.**
-dontwarn org.simpleframework.xml.**
-keep class org.simpleframework.xml.**{*;}

-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}

-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}


-keep public class com.adjust.sdk.** { *; }
-keep class com.google.android.gms.common.ConnectionResult {
    int SUCCESS;
}
-keep class com.google.android.gms.ads.identifier.AdvertisingIdClient {
    com.google.android.gms.ads.identifier.AdvertisingIdClient$Info getAdvertisingIdInfo(android.content.Context);
}
-keep class com.google.android.gms.ads.identifier.AdvertisingIdClient$Info {
    java.lang.String getId();
    boolean isLimitAdTrackingEnabled();
}
-keep public class com.android.installreferrer.** { *; }

# MoPub Proguard Config
# NOTE: You should also include the Android Proguard config found with the build tools:
# $ANDROID_HOME/tools/proguard/proguard-android.txt

# Keep public classes and methods.
-keepclassmembers class com.mopub.** { public *; }
-keep public class com.mopub.**
-keep public class android.webkit.JavascriptInterface {}

# Explicitly keep any custom event classes in any package.
-keep class * extends com.mopub.mobileads.CustomEventBanner {}
-keep class * extends com.mopub.mobileads.CustomEventInterstitial {}
-keep class * extends com.mopub.mobileads.CustomEventRewardedAd {}
-keep class * extends com.mopub.nativeads.CustomEventNative {}

# Keep methods that are accessed via reflection
-keepclassmembers class ** { @com.mopub.common.util.ReflectionTarget *; }

# Support for Android Advertiser ID.
-keep class com.google.android.gms.common.GooglePlayServicesUtil {*;}
-keep class com.google.android.gms.ads.identifier.AdvertisingIdClient {*;}
-keep class com.google.android.gms.ads.identifier.AdvertisingIdClient$Info {*;}

# Support for Google Play Services
# http://developer.android.com/google/play-services/setup.html
-keep class * extends java.util.ListResourceBundle {
    protected Object[][] getContents();
}

-keep public class com.google.android.gms.common.internal.safeparcel.SafeParcelable {
    public static final *** NULL;
}

-keepnames @com.google.android.gms.common.annotation.KeepName class *
-keepclassmembernames class * {
    @com.google.android.gms.common.annotation.KeepName *;
}

-keepnames class * implements android.os.Parcelable {
    public static final ** CREATOR;
}
-keep class com.android.vending.billing.**
-keepnames class kotlinx.coroutines.internal.MainDispatcherFactory {}
-keepnames class kotlinx.coroutines.CoroutineExceptionHandler {}

# Most of volatile fields are updated with AFU and should not be mangled
-keepclassmembernames class kotlinx.** {
    volatile <fields>;
}
-dontwarn kotlin.Unit
-keepnames class kotlinx.coroutines.internal.MainDispatcherFactory {}
-keepnames class kotlinx.coroutines.CoroutineExceptionHandler {}
-keepnames class kotlinx.coroutines.android.AndroidDispatcherFactory {}
-keep class kotlinx.coroutines.android.AndroidExceptionPreHandler
-keep class kotlinx.coroutines.android.AndroidDispatcherFactory
-keep class kotlinx.coroutines.android.AndroidDispatcherFactory {*;}
-keepnames class kotlinx.coroutines.test.internal.TestMainDispatcherFactory {}
-keepnames class kotlinx.coroutines.android.AndroidExceptionPreHandler {}

-keep public class com.google.vending.licensing.ILicensingService
-keep public class com.android.vending.licensing.ILicensingService
-dontwarn com.arialyy.aria.**
-keep class com.arialyy.aria.**{*;}
-keep class **$$DownloadListenerProxy{ *; }
-keep class **$$UploadListenerProxy{ *; }
-keep class **$$DownloadGroupListenerProxy{ *; }
-keepclasseswithmembernames class * {
    @Download.* <methods>;
    @Upload.* <methods>;
    @DownloadGroup.* <methods>;
}



# 360
# 架构基础类
-keep class com.qihoo360.replugin.RePlugin {
    public protected *;
}
# LocalBroadcastManager，插件会用
-keep public class android.support.v4.content.LocalBroadcastManager {
    public *;
}

# 架构具体实现，和插件反射调用部分
-keep class com.qihoo360.replugin.model.PluginInfo {
    public protected *;
}
-keep class com.qihoo360.replugin.IBinderGetter {
     public protected *;
}
-keep class com.qihoo360.replugin.component.ComponentList {
    public protected *;
}
-keep class com.qihoo360.framework.** {
    public protected *;
}
-keep class com.qihoo360.i.** {
    public protected *;
}
-keep class com.qihoo360.plugins.** {
    public protected *;
}
-keep class com.qihoo360.plugin.** {
    public protected *;
}
-keep class com.qihoo360.replugin.component.dummy.** {
    public protected *;
}
-keep class com.qihoo360.replugin.component.provider.PluginProviderClient {
    public protected *;
}
-keep class com.qihoo360.replugin.component.provider.PluginProviderClient2 {
    public protected *;
}
-keep class com.qihoo360.replugin.component.service.PluginServiceClient {
    public protected *;
}
-keep class com.qihoo360.replugin.component.provider.PluginPitProviderP0 { public protected *; }
-keep class com.qihoo360.replugin.component.provider.PluginPitProviderP1 { public protected *; }
-keep class com.qihoo360.replugin.component.provider.PluginPitProviderP2 { public protected *; }

# ProcessPitProviderP0 未被自动 keep
-keep class com.qihoo360.replugin.component.process.ProcessPitProviderP0 { public protected *; }
-keep class com.qihoo360.replugin.component.process.ProcessPitProviderP1 { public protected *; }
-keep class com.qihoo360.replugin.component.process.ProcessPitProviderP2 { public protected *; }

# Pref
-keep public class com.qihoo360.mobilesafe.api.Pref {
    public *;
}
# IPC
-keep public class com.qihoo360.mobilesafe.api.IPC {
    public *;
}
# QihooServiceManager
-keep public class com.qihoo360.mobilesafe.svcmanager.QihooServiceManager {
    public *;
}
# Old PPC/PSC
-keep class com.qihoo360.loader2.mgr.PluginProviderClient {
    public protected *;
}
-keep class com.qihoo360.loader2.mgr.PluginServiceClient {
    public protected *;
}

# ------------ keep 以下类，以防卫士主程序 AOP DEBUG 失败 ------------
-keep class com.qihoo360.replugin.component.activity.ActivityInjector { *;}

# replugin-host-gradle 生成的 java 文件
-keep class com.qihoo360.replugin.gen.RePluginHostConfig { public *; }



# OKHTTP
-dontwarn com.squareup.okhttp.**
-keep class com.squareup.okhttp.** { *;}
-dontwarn okio.**
-keep class okhttp3.* { *; }
-keep interface okhttp3.* { *; }
-dontwarn okhttp3.**

# retrofit2
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions


-keep class io.reactivex.**
-keep class io.reactivex.** { *; }

# Retrofit does reflection on generic parameters. InnerClasses is required to use Signature and
# EnclosingMethod is required to use InnerClasses.
-keepattributes Signature, InnerClasses, EnclosingMethod

# Retrofit does reflection on method and parameter annotations.
-keepattributes RuntimeVisibleAnnotations, RuntimeVisibleParameterAnnotations

# Retain service method parameters when optimizing.
-keepclassmembers,allowshrinking,allowobfuscation interface * {
    @retrofit2.http.* <methods>;
}

# Ignore annotation used for build tooling.
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement

# Ignore JSR 305 annotations for embedding nullability information.
-dontwarn javax.annotation.**

# Guarded by a NoClassDefFoundError try/catch and only used when on the classpath.
-dontwarn kotlin.Unit

# Top-level functions that can only be used by Kotlin.
-dontwarn retrofit2.KotlinExtensions

# With R8 full mode, it sees no subtypes of Retrofit interfaces since they are created with a Proxy
# and replaces all potential values with null. Explicitly keeping the interfaces prevents this.
-if interface * { @retrofit2.http.* <methods>; }
-keep,allowobfuscation interface <1>

# rxjava
-dontwarn sun.misc.**
-keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
 long producerIndex;
 long consumerIndex;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
 rx.internal.util.atomic.LinkedQueueNode producerNode;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueConsumerNodeRef {
 rx.internal.util.atomic.LinkedQueueNode consumerNode;
}


-keepattributes *Annotation*,EnclosingMethod
-keep public class org.simpleframework.**{ *; }
-keep public class org.simpleframework.xml.**{ *; }
-keep public class org.simpleframework.xml.core.**{ *; }
-keep public class org.simpleframework.xml.util.**{ *; }
-keep public class org.simpleframework.xml.stream.**{ *; }
-keep public class javax.** { *; }
-keep public class javax.xml.stream.**{ *; }
-keep public class org.simpleframework.** {
  public void set*(***);
  public *** get*();
}

# don't obfuscate Jackson classes
-keep class com.fasterxml.** { *; }

# don't strip runtime annotations
-keepattributes RuntimeVisibleAnnotations
-keepclassmembers class * {
     @com.fasterxml.jackson.annotation.JsonCreator *;
     @com.fasterxml.jackson.annotation.JsonProperty *;
}

# adjust
-keep public class com.adjust.sdk.** { *; }
-keep class com.google.android.gms.common.ConnectionResult {
    int SUCCESS;
}
-keep class com.google.android.gms.ads.identifier.AdvertisingIdClient {
    com.google.android.gms.ads.identifier.AdvertisingIdClient$Info getAdvertisingIdInfo(android.content.Context);
}
-keep class com.google.android.gms.ads.identifier.AdvertisingIdClient$Info {
    java.lang.String getId();
    boolean isLimitAdTrackingEnabled();
}
-keep public class com.android.installreferrer.** { *; }

# Eventbus
-keepattributes *Annotation*
-keepclassmembers class * {
    @org.greenrobot.eventbus.Subscribe <methods>;
}
-keep enum org.greenrobot.eventbus.ThreadMode { *; }
-keep class org.greenrobot.eventbus.** { *; }

# Only required if you use AsyncExecutor
-keepclassmembers class * extends org.greenrobot.eventbus.util.ThrowableFailureEvent {
    <init>(java.lang.Throwable);
}

# MoPub
# MoPub Proguard Config
# NOTE: You should also include the Android Proguard config found with the build tools:
# $ANDROID_HOME/tools/proguard/proguard-android.txt

# Keep public classes and methods.
-keepclassmembers class com.mopub.** { public *; }
-keep public class com.mopub.**
-keep public class android.webkit.JavascriptInterface {}

# Explicitly keep any custom event classes in any package.
-keep class * extends com.mopub.mobileads.CustomEventBanner {}
-keep class * extends com.mopub.mobileads.CustomEventInterstitial {}
-keep class * extends com.mopub.mobileads.CustomEventRewardedAd {}
-keep class * extends com.mopub.nativeads.CustomEventNative {}

# Keep methods that are accessed via reflection
-keepclassmembers class ** { @com.mopub.common.util.ReflectionTarget *; }

# Support for Android Advertiser ID.
-keep class com.google.android.gms.common.GooglePlayServicesUtil {*;}
-keep class com.google.android.gms.ads.identifier.AdvertisingIdClient {*;}
-keep class com.google.android.gms.ads.identifier.AdvertisingIdClient$Info {*;}

# Support for Google Play Services
# http://developer.android.com/google/play-services/setup.html
-keep class * extends java.util.ListResourceBundle {
    protected Object[][] getContents();
}

-keep public class com.google.android.gms.common.internal.safeparcel.SafeParcelable {
    public static final *** NULL;
}

-keepnames @com.google.android.gms.common.annotation.KeepName class *
-keepclassmembernames class * {
    @com.google.android.gms.common.annotation.KeepName *;
}

-keepnames class * implements android.os.Parcelable {
    public static final ** CREATOR;
}

# Tapjoy
-keep class com.tapjoy.** { *; }
-keepattributes JavascriptInterface
-keepattributes *Annotation*
-keep class * extends java.util.ListResourceBundle {
protected Object[][] getContents();
}
-keep public class com.google.android.gms.common.internal.safeparcel.SafeParcelable {
public static final *** NULL;
}
-keepnames @com.google.android.gms.common.annotation.KeepName class *
-keepclassmembernames class * {
@com.google.android.gms.common.annotation.KeepName *;
}
-keepnames class * implements android.os.Parcelable {
public static final ** CREATOR;
}
-keep class com.google.android.gms.ads.identifier.** { *; }
-dontwarn com.tapjoy.**

# For communication with AdColony's WebView
-keepclassmembers class * {
    @android.webkit.JavascriptInterface <methods>;
}

# AdMob
# For Google Play Services
-keep public class com.google.android.gms.ads.**{
   public *;
}

# For old ads classes
-keep public class com.google.ads.**{
   public *;
}
-keep class com.android.vending.billing.**
# For mediation
-keepattributes *Annotation*

# Other required classes for Google Play Services
# Read more at http://developer.android.com/google/play-services/setup.html
-keep class * extends java.util.ListResourceBundle {
   protected Object[][] getContents();
}

-keep public class com.google.android.gms.common.internal.safeparcel.SafeParcelable {
   public static final *** NULL;
}

-keepnames @com.google.android.gms.common.annotation.KeepName class *
-keepclassmembernames class * {
   @com.google.android.gms.common.annotation.KeepName *;
}

-keepnames class * implements android.os.Parcelable {
   public static final ** CREATOR;
}

# ironsource
-keepclassmembers class com.ironsource.sdk.controller.IronSourceWebView$JSInterface {
    public *;
}
-keepclassmembers class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}
-keep public class com.google.android.gms.ads.** {
   public *;
}
-keep class com.ironsource.adapters.** { *;
}
-dontwarn com.moat.**
-keep class com.moat.** { public protected private *; }
-keepclassmembers class com.ironsource.sdk.controller.IronSourceWebView$JSInterface {
    public *;
}
-keepclassmembers class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}
-keep public class com.google.android.gms.ads.** {
   public *;
}
-keep class com.ironsource.adapters.** { *;
}
-dontwarn com.ironsource.mediationsdk.**
-dontwarn com.ironsource.adapters.**
-dontwarn com.moat.**
-keep class com.moat.** { public protected private *; }
# flurry
# Required to preserve the Flurry SDK
-keep class com.flurry.** { *; }
-dontwarn com.flurry.**
-keepattributes *Annotation*,EnclosingMethod,Signature
-keepclasseswithmembers class * {
   public <init>(android.content.Context, android.util.AttributeSet, int);
 }

 # Google Play Services library
  -keep class * extends java.util.ListResourceBundle {
   protected Object[][] getContents();
}

 -keep public class com.google.android.gms.common.internal.safeparcel.SafeParcelable {
  public static final *** NULL;
 }

 -keepnames @com.google.android.gms.common.annotation.KeepName class *
 -keepclassmembernames class * {
    @com.google.android.gms.common.annotation.KeepName *;
  }

 -keepnames class * implements android.os.Parcelable {
  public static final ** CREATOR;
 }

 # Vungle
 -keep class com.vungle.warren.** { *; }
 -dontwarn com.vungle.warren.error.VungleError$ErrorCode
 # Evernote
 -dontwarn com.evernote.android.job.gcm.**
 -dontwarn com.evernote.android.job.GcmAvailableHelper
 -dontwarn com.google.android.gms.ads.identifier.**
 -keep public class com.evernote.android.job.v21.PlatformJobService
 -keep public class com.evernote.android.job.v14.PlatformAlarmService
 -keep public class com.evernote.android.job.v14.PlatformAlarmReceiver
 -keep public class com.evernote.android.job.JobBootReceiver
 -keep public class com.evernote.android.job.JobRescheduleService
 -dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
 -keep class com.google.android.gms.internal.** { *; }
 # Moat SDK
 -keep class com.moat.** { *; }
 -dontwarn com.moat.**

 # Applovin
 -dontwarn com.applovin.**

 -keep class com.applovin.** { *; }

 # Virtual Note: 以下混淆必加 start
 -keep class com.didi.virtualapk.internal.VAInstrumentation { *; }
 -keep class com.didi.virtualapk.internal.PluginContentResolver { *; }
 -keep class com.android.vending.billing.** { *; }

 -dontwarn com.didi.virtualapk.**
 -dontwarn android.**
 -keep class android.** { *; }
 -keep class androidx.** { *; }
-dontwarn javax.annotation.Nullable
-dontwarn com.google.**
-keep class javax.annotation.** { *; }
-dontwarn javax.annotation.**
-keepclasseswithmembernames class * {
    native <methods>;
}
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}
-keep class **.R$* {
 *;
}
-keepclassmembers class * {
    void *(**On*Event);
}
-keep public class * extends android.view.View {
    *** get*();
    void set*(***);
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
-dontwarn com.squareup.okhttp.**
-keep class com.squareup.okhttp.** { *;}
-dontwarn okio.**
-keep  class okio.** { *; }
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions
-dontwarn sun.misc.**
-keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
 long producerIndex;
 long consumerIndex;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
 rx.internal.util.atomic.LinkedQueueNode producerNode;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueConsumerNodeRef {
 rx.internal.util.atomic.LinkedQueueNode consumerNode;
}
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public class * extends com.bumptech.glide.module.AppGlideModule
-keep public enum com.bumptech.glide.load.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}
-dontwarn com.bumptech.glide.load.resource.bitmap.VideoDecoder
-keep class * extends com.raizlabs.android.dbflow.config.DatabaseHolder { *; }
-keep class com.raizlabs.android.**
-keep class com.raizlabs.android.** {*;}
-keepattributes *Annotation*
-keepclassmembers class ** {
    @org.greenrobot.eventbus.Subscribe <methods>;
}
-keep enum org.greenrobot.eventbus.ThreadMode { *; }
-keepclassmembers class * extends org.greenrobot.eventbus.util.ThrowableFailureEvent {
    <init>(java.lang.Throwable);
}
-keep  class com.alibaba.fastjson.**{ *;}
-dontwarn com.alibaba.fastjson.**
-dontskipnonpubliclibraryclassmembers
-dontskipnonpubliclibraryclasses
-keep class * implements java.io.Serializable { *; }
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions
-keep class io.reactivex.**
-keep class io.reactivex.** { *; }
-dontwarn okhttp3.**
-keep class okhttp3.**{*;}
-keep interface okhttp3.**{*;}
-dontwarn com.gpower.billing.provider.**
-dontwarn com.google.gson.**
-keep class com.gpower.billing.provider.** {*;}
-keep class com.google.gson.** {*;}
-keepattributes *Annotation*,EnclosingMethod
-keep public class org.simpleframework.**{ *; }
-keep public class org.simpleframework.xml.**{ *; }
-keep public class org.simpleframework.xml.core.**{ *; }
-keep public class org.simpleframework.xml.util.**{ *; }
-keep public class org.simpleframework.xml.stream.**{ *; }
-keep public class javax.** { *; }
-keep public class javax.xml.stream.**{ *; }
-keep public class org.simpleframework.** {
  public void set*(***);
  public *** get*();
}
-keep class com.fasterxml.** { *; }
-keepattributes RuntimeVisibleAnnotations
-keepclassmembers class * {
     @com.fasterxml.jackson.annotation.JsonCreator *;
     @com.fasterxml.jackson.annotation.JsonProperty *;
}
-keep class com.instlikebase.component.BadgeActionProvider
-dontwarn okhttp3.logging.**
-dontwarn info.guardianproject.netcipher.client.**
-dontwarn org.greenrobot.greendao.**
-dontwarn com.fasterxml.jackson.**
-dontwarn retrofit2.Platform$Java8
-dontwarn com.paypal.android.sdk.**
-dontwarn com.squareup.picasso.**
-dontwarn org.simpleframework.xml.**
-keep class org.simpleframework.xml.**{*;}
-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}
-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}
-keep class com.adjust.sdk.** { *; }
-keep class com.google.android.** { *; }
-keep class com.google.android.gms.** { *; }
-keep class com.google.android.gms.common.** { *; }
-keep class com.google.android.gms.ads.identifier.** { *; }
-dontwarn com.google.android.gms.**
-keep public class com.adjust.sdk.** { *; }
-keep class com.google.android.gms.common.ConnectionResult {
    int SUCCESS;
}
-keep class com.google.android.gms.ads.identifier.AdvertisingIdClient {
    com.google.android.gms.ads.identifier.AdvertisingIdClient$Info getAdvertisingIdInfo(android.content.Context);
}
-keep class com.google.android.gms.ads.identifier.AdvertisingIdClient$Info {
    java.lang.String getId();
    boolean isLimitAdTrackingEnabled();
}
-keep public class com.android.installreferrer.** { *; }
-keep public class com.adjust.sdk.** { *; }
-keep class com.google.android.material.** {*;}
-keep class androidx.** {*;}
-keep interface androidx.** {*;}
-dontwarn com.google.android.material.**
-dontnote com.google.android.material.**
-dontwarn androidx.**
-keep class com.facebook.**
-keep class com.facebook.** {*;}
-keep class com.didi.virtualapk.internal.VAInstrumentation { *; }
-keep class com.didi.virtualapk.internal.PluginContentResolver { *; }
-dontwarn com.didi.virtualapk.**
-dontwarn android.content.pm.**
-keep class android.** { *; }
-keep class androidx.** { *; }
-keep class com.bumptech.glide.**
-keep class com.bumptech.glide.** { *; }
# Virtual Note: 以下混淆必加 end


 # smaato
 -dontwarn com.smaato.soma.SomaUnityPlugin*
 -dontwarn com.millennialmedia**
 -dontwarn com.facebook.**

 -dontwarn com.kuaiyou.**
 -keep class com.kuaiyou.**
 -keep class com.kuaiyou.**{*;}
 -keep class com.adview.post.AdViewDefault
 -keep class com.adview.post.AdViewDefault {*;}



 -obfuscationdictionary dictionary-elder.txt
 -classobfuscationdictionary dictionary-elder.txt
 -packageobfuscationdictionary dictionary-elder.txt
 -keep class com.tapque.** { *;}

 # TODO: 以下地方混淆需要随着项目包自行更改
 -keep class com.getwatermark.photomaker.lscj.Pu
 -keep class com.getwatermark.photomaker.lscj.Pu {*;}
 -keep class com.getwatermark.photomaker.lscj.cs.wc.**
 -keep class com.getwatermark.photomaker.lscj.cs.wc.**{*;}

 -keep class com.jvn.pow.**{*;}
 -keep class com.jvn.pow.**
