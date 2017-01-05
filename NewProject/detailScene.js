import React, {Component} from 'react';
import {
   TouchableHighlight,
   AppRegistry,
   StyleSheet,
   Text,
   View, TextInput,Picker
} from 'react-native';
const Realm = require('realm');
let realm = new Realm({
  schema: [{name: 'MyEvent',
    properties: {
      title: 'string',
      type: 'string',
      details: 'string',
}}]
});

class DetailScreen extends Component {
  constructor(props){
    super(props);
    this.state = {};
  }


  render() {
    return (
      <View style={styles.container}>

         <Text>{this.props.title}</Text>

         <TextInput
           placeholder={this.props.type}
           onChangeText={(text) =>realm.write(()=> {
            let element=realm.objects('MyEvent').find((event) => this.props.name == event.title);
          element.type=text;
        })}

           />

	        <TextInput
          placeholder={this.props.details}
          onChangeText={(text) =>realm.write(()=> {
           let element=realm.objects('MyEvent').find((event) => this.props.name == event.title);
         element.details=text;
       })}
            />
            <Text style={{paddingTop:30}}>Buy tickets </Text>

            <Picker
              selectedValue={this.state.tickets}
              onValueChange={(no) => this.setState({tickets: no})}>
              <Picker.Item label="1" value="1" />
              <Picker.Item label="2" value="2" />

              <Picker.Item label="3" value="3" />

              <Picker.Item label="4" value="4" />

            </Picker>

            <Text>You chose to buy {this.state.tickets} tickets </Text>
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
