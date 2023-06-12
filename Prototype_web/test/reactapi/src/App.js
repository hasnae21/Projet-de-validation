import { Component } from "react";

class App extends Component {

  constructor(props) {
    super(props);
    this.state = {
      items: [],
      isLoaded: false,
    }
  }

  $word = "book";
  componentDidMount() {
    fetch('https://api.dictionaryapi.dev/api/v2/entries/en/'+ this.$word)
      .then(res => res.json())
      .then(res => console.log(res))
      .then(json => {
        this.setState({
          isLoaded: true,
          items: json,
        })
      });
  }

  render() {
    var { isLoaded, items } = this.state;

    if (!isLoaded) {
      return <div> Loading... </div>;
    }
    else {
      return (
        <div className="App">

          <ul>
            {/* {items.map(item => ( */}
            {/* <li key={item.id}> */}
            <li>
              {items.phonetics.audio}

            </li>
            {/* ))} */}
          </ul>

        </div>
      );
    }

  }
}

export default App;
