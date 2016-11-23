/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
  AppRegistry, Navigator,
  StyleSheet,
  Text,TextInput,
  View,
  TouchableOpacity
} from 'react-native';

import Communications from 'react-native-communications';
import EmailScene from './emailScene';

class EventAppReact extends Component {
  render() {
    return (
      <Navigator
      initialRoute={{ title: 'EmailScene', index: 0 }}
      renderScene={(route, navigator) =>
        <EmailScene
          title={route.title}

          // Function to call when a new scene should be displayed
          onForward={ () => {
            const nextIndex = route.index + 1;
            navigator.push({
              title: 'Scene ' + nextIndex,
              index: nextIndex,
            });
          }}

          // Function to call to go back to the previous scene
          onBack={() =>
            { if (route.index > 0) {
              navigator.pop();
            }
          }}
          />
        }
        />
      )
     }
   }
AppRegistry.registerComponent('EventAppReact', () => EventAppReact);
