import { NativeModules, Platform } from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-firstnativemod' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

const FingerPrint = NativeModules.FingerPrint
  ? NativeModules.FingerPrint
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

export function showBiometric(
  a: string,
  b: string,
  c: string,
  callBack: Function
) {
  FingerPrint.showBiometric(a, b, c, callBack);
}

export function showPatternSheet() {
  FingerPrint.showPatternSheet();
}
