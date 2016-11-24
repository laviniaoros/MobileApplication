import React, { Component,PropTypes } from 'react';
import {
  View,
   ListView,
   StyleSheet,
   Navigator,
   TouchableOpacity,
 Text
} from 'react-native';



const styles = StyleSheet.create({
  container: {
    flex: 1,
    marginTop: 20,
  },
  separator: {
    flex: 1,
    height: StyleSheet.hairlineWidth,
    backgroundColor: '#8E8E8E',
  },
  progress: {
    marginTop: 80,
  },
});

export default class ListScreen extends Component {
  constructor(props) {
  super(props);
  const ds = new ListView.DataSource({rowHasChanged: (r1, r2) => r1 !== r2});
  this.state = {
    dataSource: ds.cloneWithRows([
      'John', 'Joel', 'James', 'Jimmy', 'Jackson', 'Jillian', 'Julie', 'Devin'
    ])
  };
}
render() {
  return (
    <View style={{style.container}}>
      <Text style={{styles.titleText}}>Events</Text>
      <ListView
        dataSource={this.state.dataSource}
        renderRow={(rowData) => <Text style={{style}}>{rowData}</Text>}
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
