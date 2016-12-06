import React, { Component,PropTypes } from 'react';
import {
  View,
   ListView,
   StyleSheet,
   Navigator,
   TouchableOpacity,
 Text
} from 'react-native';


var myEvents = [
  {name: 'Die Hard', details: 'Best movie ever'},
  {name: 'Home Alone 2', details: 'Great movie'},
  {name: 'Bourne Identity', details: 'Awesome Movie'}
  ]


export default class ListScreen extends Component {
  constructor(props){
  super(props);
  const ds = new ListView.DataSource({rowHasChanged: (r1, r2) => r1 !== r2});
  this.state = {
    dataSource: ds.cloneWithRows(myEvents)
  };
  }
render() {

  return (

    <ListView style={{paddingTop:40}}
        dataSource={this.state.dataSource}
        renderRow={(rowData) =>
          <TouchableOpacity onPress={()=> this.props.navigator.push({id:'Detail',
                     passProps:{
                         name: rowData.name,
                         details: rowData.details
                      }})}>
                     <View style={{height:50}}>
                       <Text style={{fontSize:20, left:20}}>{rowData.name}</Text>
                     </View>
          </TouchableOpacity>
                  }
    />
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
