import React, { Component,PropTypes } from 'react';
import {
  Navigator,
  AppRegistry,
  StyleSheet,
  Text,TextInput,
  View,
  TouchableOpacity
} from 'react-native';

import Communications from 'react-native-communications';
import ListScreen from './listScene.js';

const routes = [
  {
    title: 'ListScreen',
    index: 0
}
]

export default class EmailScene extends Component {
    constructor(props) {
      super(props);
      this.state = {text1: '', text2:''};
    }
    render() {
      return (
        <View style={{padding: 10, flex:1}}>
          <TextInput
            style={{height: 40}}
            placeholder="Type here to translate!"
            onChangeText={(text1) => this.setState({text1})}
            />
            <TextInput
              style={{height: 40}}
              placeholder="Type here to translate!"
              onChangeText={(text2) => this.setState({text2})}
            />
          <View style={styles.container}>
              <TouchableOpacity onPress={() => Communications.email(this.state.text1,null,null,this.state.text2,'My body text')}>
                <View style={styles.holder}>
                  <Text style={styles.text}>Send an email</Text>
                </View>
              </TouchableOpacity></View>



      </View>
    );
  }
}
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
  navigationBar:{
   backgroundColor: 'darkred',
 },
 navigationBarText:{
   color: 'white',
   padding: 10,
   fontSize: 15
 },
 titleText:{
   fontSize: 20,
   paddingTop:5
 }
})
EmailScene.propTypes = {
  title: PropTypes.string.isRequired,
  onForward: PropTypes.func.isRequired,
  onBack: PropTypes.func.isRequired,
};
