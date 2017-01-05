import React, { Component,PropTypes } from 'react';
import {
  Alert,View,
   ListView,
   StyleSheet,
   Navigator,
   TouchableOpacity,
   TouchableHighlight,
   TextInput,
 Text,ScrollView , StatusBar,Picker
} from 'react-native';
import PieChart from 'react-native-pie-chart';

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
      // realm.write(() => {
      //      realm.create('MyEvent', {
      //          title: 'Quiz Night',
      //          type:'party',
      //          details: 'Tonight at 7pm',
      //      });
      //  });

      let events=realm.objects('MyEvent');

      return {
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

    let party= realm.objects('MyEvent').filtered('type = "thematic party"');
    const p=party.length;

    let chart_wh = 100

    let sliceColor = ['#F44336','#2196F3','#FFEB3B', '#4CAF50']
    let series = [2,2,2,2]

    return (
      <ScrollView>
      <View style={{paddingTop:50}}>
      <Text>Fill the text fields below to add a new event</Text>
        <TextInput
        style={{height: 40}}
          placeholder="title"
          onChangeText={(text1) => this.setState({text1})}
        />

				    <Picker
          onValueChange={(text2) => this.setState({text2})}
          selectedValue={this.state.text2}
                                      >
          <Picker.Item label="networking networking" value="networking" />

          <Picker.Item label="conference" value="conference" />
          <Picker.Item label="themetic party" value="thematic party" />

          <Picker.Item label="concert" value="concert" />
</Picker>
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
        <Text>{realm.objects('MyEvent').length}</Text>

      <ListView style={{paddingTop:30}}
        dataSource = {this.state.dataSource}
        renderRow = { (rowData)=>
          <View>
          <Text style={{fontSize:20}}
               onPress={ () => Alert.alert(
                 'Delete Event ' + rowData.title,
                   'Would you like to  delete this item? ',
                 [
                   {text:'Details', onPress: () => this.props.navigator.push({id:'Detail',
                     passProps:{
                         name: rowData.title,
                         type:rowData.type,
                         details: rowData.details
                      }}) },
                   {text:'Cancel'},
                   {text:'Ok', onPress: () => realm.write(()=> {
                     realm.delete(realm.objects('MyEvent').find((event) => rowData.title == event.title))}
                     )},
                 ]
               )} >
             {rowData.title}

           </Text>
        </View>
        }
      />
      <View style={styles.container}>

               <Text style={styles.title}> The statistics, types of events</Text>
               <PieChart
                 chart_wh={chart_wh}
                 series={series}
                 sliceColor={sliceColor}
               />
           </View>
    </View>
    </ScrollView>
  );

  }
}

const styles = StyleSheet.create({
  container: {
      paddingTop:50,
      flex: 1,
      alignItems: 'center'
    },
    title: {
      fontSize: 15,
      margin: 10
    },
titleText:{
fontSize: 20,
paddingTop:5
}

});
