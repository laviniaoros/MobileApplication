import React, { Component,PropTypes } from 'react';
import {
  View,
   ListView,
   StyleSheet,
   Navigator,
   TouchableOpacity,
 Text
} from 'react-native';





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
    <View style={{flex: 1, paddingTop: 22}}>
      <ListView
        dataSource={this.state.dataSource}
        renderRow={(rowData) => <Text>{rowData}</Text>}
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
