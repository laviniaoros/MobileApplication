import React, { Component,PropTypes } from 'react';
import {
  Navigator,
  AppRegistry,
  StyleSheet,
  Text,TextInput,
  View,
  TouchableOpacity,TouchableHighlight
} from 'react-native';

import Communications from 'react-native-communications';
import ListScreen from './listScene.js';



export default class EmailScene extends Component {
    onButtonPress(){
      this.props.navigator.push({
        id:'List'
      })
    }
    render() {

      return (
        <View style={{padding: 10, flex:1}}>
          <TextInput
            style={{height: 40}}
            placeholder="tell us your name"
            onChangeText={(text1) => this.setState({text1})}
            />
            <TextInput
              style={{height: 40}}
              placeholder="tell us your suggestions"
              onChangeText={(text2) => this.setState({text2})}
            />
          <View style={styles.container}>
              <TouchableOpacity onPress={() => Communications.email(['lavi_mioara@yahoo.com'],null,null,"Sugesttions from "+this.state.text1,this.state.text2)}>
                <View style={styles.holder}>
                  <Text style={styles.text}>Send an email</Text>
                </View>
              </TouchableOpacity>
          </View>
          <TouchableHighlight style={styles.navigation_bar} onPress={this.onButtonPress.bind(this)}>
              <Text> Go now, will you? </Text>
          </TouchableHighlight>
        </View>

    );
  }
};



var styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    backgroundColor: 'rgb(253,253,253)',
  },
  holder: {
    flex: 0.25,
    justifyContent: 'center',
  },
  text: {
    fontSize: 32,
  },
  navigation_bar:{
   backgroundColor: 'darkred',
   color: 'white',
   padding: 10,
   fontSize: 15
 }
})
