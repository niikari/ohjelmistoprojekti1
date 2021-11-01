import logo from './logo.svg';
import React from 'react';
import './App.css';
import qService from './services/question';


function App() {
  const [questions, setQuestions] = React.useState([]);

  const getQuestions = () => {
    qService
    .getAll()
    .then(data => {
      console.log(data._embedded.questions);
      setQuestions(data._embedded.questions);
      console.log(questions);
    })
    .catch(err => console.error('Virhe: ' +err));
  }

  React.useEffect(() => {
    getQuestions();
}, [])
  
  return (
    <div className="App">
      {questions.map((q) => 
      <tr key={q}>
        <td>{q.quest}</td>
      </tr>
      )}
    </div>
  );
}

export default App;
