import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {

    constructor(props){
        super(props)
        this.state = {
            testMe: "test XXX"
        }
    }

    bla = () => {
        fetch('/api/sensor/8773887')
            .then(function(response) {
                return response.text();
            })
            .then(myJson => {
                console.log(myJson)
                this.setState({
                    testMe: myJson
                })
            });
    }

  componentDidMount(){
    this.bla()
  }

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">Welcome to React</h1>
        </header>
        <p className="App-intro">
        </p>

          <div>{this.state.testMe}</div>
      </div>
    );
  }
}

export default App;
