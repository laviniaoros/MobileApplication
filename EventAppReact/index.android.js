/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */
 import React, {Component} from 'react';
 import {
    Navigator,
    StatusBar,
    TouchableHighlight,
    AppRegistry,
    StyleSheet,
    Text,
    View
 } from 'react-native';
import Communications from 'react-native-communications';

import EmailScene from './emailScene.js';
import ListScreen from './listScene';



class EventAppReact extends Component {
  render() {
    return (

        <Navigator
           initialRoute = {{
             id: 'Email'
           }}
           renderScene = {
             this.navigatorRenderScene
           }
        />
    );
  }

  navigatorRenderScene(route,navigator){
    _navigator=navigator;
    switch (route.id){
      case 'Email':
        return (<EmailScene navigator={navigator} title='Email'/>)
      case 'List':
        return (<ListScreen navigator={navigator} title='List'/>)

    }
  }

}



AppRegistry.registerComponent('EventAppReact', () => EventAppReact);
