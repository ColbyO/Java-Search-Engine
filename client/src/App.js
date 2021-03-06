import { BrowserRouter as Router, Switch, Route } from 'react-router-dom'

//Routing
import PrivateRoute from './components/routing/PrivateRoute';

//Pages
import SearchPage from './components/pages/SearchPage';
import LoginPage from './components/pages/LoginPage';
import RegisterPage from './components/pages/RegisterPage';
import History from './components/pages/History';

const App = () => {
  return (
    <Router>
    <div className="App">
      <Switch>
        {/******************* PRIVATE ROUTES *******************/}
        <PrivateRoute exact path="/" component={SearchPage} />
        <PrivateRoute exact path="/history" component={History} />
        
        {/******************* ROUTES *******************/}
        <Route exact path="/login" component={LoginPage} />
        <Route exact path="/register" component={RegisterPage} />
      </Switch>
    </div>
    </Router>
  );
}

export default App;
