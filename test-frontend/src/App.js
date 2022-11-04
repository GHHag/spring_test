import { useEffect, useState } from 'react';
//import logo from './logo.svg';
import logo from './archlinux-512.png';
import './App.css';

function App() {
  const [test, setTest] = useState(null);
  const [superHeroes, setSuperHeroes] = useState([]);
  console.log(superHeroes);

  const endpointCReq = async () => {
    await fetch('http://localhost:8080/c',
      {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({ message: 'body message' })
      }
    );
  }

  const endpointD2Req = async () => {
    await fetch('http://localhost:8080/d2',
      {
        method: 'GET',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        }//,
        //body: JSON.stringify({ message: 'body message' })
      }
    );
  }

  const endpointEReq = async () => {
    await fetch('http://localhost:8080/e',
      {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          message: 'body message',
          arg1: 'arg1',
          arg2: 'arg2',
          arg3: 'arg3',
          arg4: 'arg4'
        })
      }
    );
  }

  const getSuperHeroesReq = async () => {
    await fetch('http://localhost:8080/superheroes')
      .then((res) => res.body)
      .then((body) => {
        const reader = body.getReader().read().then((x) => {
          setSuperHeroes(JSON.parse(new TextDecoder().decode(x.value)));
        });
      });
  }

  useEffect(() => {
    const getTest = async () => {
      await fetch('http://localhost:8080/test2')
        .then((res) => res.body)
        .then((body) => {
          const reader = body.getReader().read().then((x) => {
            setTest(new TextDecoder().decode(x.value));
          });
        });
    }

    getTest();
    //endpointCReq();
    //endpointD2Req();
    endpointEReq();
  }, [])


  return (
    <div className="App">
      <h1>{test}</h1>
      <header className="App-header">
        <div>
          <button onClick={() => getSuperHeroesReq()}>SuperhjÖltar</button>
          {
            superHeroes.map((x, id) => (
              <div key={id}>
                <div> Namn: {x.name}</div>
                <div>Ölder: {x.age}</div>
                <div>Superkrafter: {x.superPowers.join(', ')}</div>
              </div>
            ))
          }
        </div >
        <img src={logo} className="App-logo" alt="logo" />
      </header>
    </div >
  );
}

export default App;
