import React from 'react';
import { BrowserRouter, Route, NavLink } from "react-router-dom";

import logo from './logo.svg';
import './App.css';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
      <NavLink
            to={"about"}
            exact
          >
            {"About us"}
          </NavLink>
          
          <NavLink
            to={"contact"}
            exact
          >
            {"Contact us"}
          </NavLink>
      <div>
        <Route path="/about" component={() => <div>About us</div>} />
        <Route path="/contact" component={() => <div>Contact us</div>} />
      </div>
    </BrowserRouter>
    </div>
  );
}

export default App;
