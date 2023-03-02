package com.firstnativemod;


import android.app.KeyguardManager;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.biometrics.BiometricManager;
import android.hardware.biometrics.BiometricPrompt;
import android.os.CancellationSignal;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@ReactModule(name = FirstnativemodModule.NAME)
public class FirstnativemodModule extends ReactContextBaseJavaModule {
  public static final String NAME = "FingerPrint";
  private static ReactApplicationContext reactApplicationContext;
  public FirstnativemodModule(ReactApplicationContext reactContext) {
    super(reactContext);
    reactApplicationContext = reactContext;
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }




  // Example method
  // See https://reactnative.dev/docs/native-modules-android
  @ReactMethod
  public void showBiometric(String title, String subTitle , String belowText , Callback callback) {

    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
      Executor executor = Executors.newSingleThreadExecutor();

      BiometricPrompt biometricPrompt =   new BiometricPrompt.Builder(getReactApplicationContext())
        .setTitle(title)
        .setSubtitle(subTitle)
        .setNegativeButton(belowText ,executor, new DialogInterface.OnClickListener(){

          @Override
          public void onClick(DialogInterface dialogInterface, int i) {

          }
        }).setNegativeButton(belowText, executor, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {

          }
        })
        .build();
      biometricPrompt.authenticate(new CancellationSignal(), executor, new BiometricPrompt.AuthenticationCallback() {
        @Override
        public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
          super.onAuthenticationSucceeded(result);
//       KeyguardManager keyguardManager = (KeyguardManager) getReactApplicationContext().getSystemService(Context.KEYGUARD_SERVICE);
//     Intent intent = keyguardManager.createConfirmDeviceCredentialIntent("c","a");
//     getCurrentActivity().startActivityForResult(intent, 3000);;

          callback.invoke(true);
        }
      });

    }


  }

  @ReactMethod
  public void showPatternSheet(Promise promise){



//    BottomDialogAuth bottomSheetDialog = new BottomDialogAuth();
//    Intent intent = new Intent(reactApplicationContext,NormalAc.class);
//    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//    reactApplicationContext.startActivity(intent);
//    promise.resolve(true);
//    bottomSheetDialog.();
//    reactApplicationContext.runOnUiQueueThread(new Runnable() {
//      @Override
//      public void run() {
////        bottomSheetDialog.show(new FragmentManager() {
//        }, "");
//
//      }
//    });




  }



}
