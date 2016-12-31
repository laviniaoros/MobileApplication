import React, { Component,PropTypes } from 'react';
import {
  Alert,View,
   ListView,
   StyleSheet,
   Navigator,
   TouchableOpacity,
   TouchableHighlight,
   TextInput,
 Text
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

export default class ListScreen extends Component {
  getState() {
  //console.log("getInitialState");
      var ds = new ListView.DataSource({rowHasChanged: (r1, r2) => r1 !== r2});


      let events=realm.objects('MyEvent');

      return {
        //dataSource: ds.cloneWithRows(['row 1', 'row 2', 'row 3']),
        dataSource: ds.cloneWithRows(events)
      };

    }

  constructor(props)
  {
      super(props);
      this.state = this.getState();
  }

  addElement(){
    realm.write(() => {
      realm.create('MyEvent', {
        title: this.state.text1,
        type:this.state.text2,
        details: this.state.text3,
   })
});

}

  render() {
    return (
      <View>
        <TextInput
        style={{height: 40}}
          placeholder="title"
          onChangeText={(text1) => this.setState({text1})}
        />
        <TextInput
          style={{height: 40}}
          placeholder="type of event"
          onChangeText={(text2) => this.setState({text2})}
        />
        <TextInput
          style={{height: 40}}
          placeholder="details"
          onChangeText={(text3) => this.setState({text3})}
        />

      <View style={{flex: 1, alignItems: 'center', justifyContent: 'center'}}>
          <TouchableHighlight onPress = {this.addElement.bind(this)}>
                  <Text>Add</Text>
          </TouchableHighlight>
        </View>
      <ListView
        dataSource = {this.state.dataSource}
        renderRow = { (rowData)=>
          <View>
           <Text>
             {rowData.title}

           </Text>
        </View>
        }
      />
    </View>
  );

  }
}

const styles = StyleSheet.create({
container:{
flex: 1
},
titleText:{
fontSize: 20,
paddingTop:5
}

});
