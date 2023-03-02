# react-native-rnbiometric

first mod

## Installation

```sh
npm install react-native-rnbiometric
```
![Screenrecorder-2023-03-01-13-32](https://user-images.githubusercontent.com/52692588/222083638-9be700c9-9b83-43da-8524-c50cf3acd5e5.gif)

## Usage

```js
import { showBiometric } from 'react-native-rnbiometric';

// ...

const isValid = await showBiometric(
  'title',
  'subtitle',
  'BottomText',
  (isValid: Boolean) => {
      ...do action
  }
);

  

 ## Params


__Options Object__
| Parameter | Type | Description  | Android |
| ---   |  --- | --- | --- |
| title | string | Title for your finger print | ✔ 
| subTitle | string | SubTitle for your finger print | ✔ 
| BottomText | string | bottom title for fingerprint | ✔ 
| Callback | Function | returns true if user is successfully authenticate | ✔

```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

work on  certificate expiry

will also work on bug fixes

work on rev dropdown changes

continue in baking station

