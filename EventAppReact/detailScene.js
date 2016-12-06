import React, {Component} from 'react';
import {
   TouchableHighlight,
   AppRegistry,
   StyleSheet,
   Text,
   View, TextInput
} from 'react-native';

class DetailScreen extends Component {
  constructor(props){
    super(props);
    this.state = {};
  }


  render() {
    return (
      <View style={styles.container}>

         <Text>{this.props.name}</Text>
	        <TextInput
            value={this.props.details}
            />
      </View>
    );
  }
}

var styles = StyleSheet.create({
  container:{
    flex:1,
    padding: 10,
    paddingTop:70,
  },
});

export default DetailScreen;
