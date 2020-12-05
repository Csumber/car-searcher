import React from 'react';
import { Switch, Route } from 'react-router-dom';
import Home from './Pages/Home';
import SearchResults from './Pages/SearchResults';
import Search from './Pages/Search';
import Recommendations from './Pages/Recommendations';

export default function Routes() {
  return (
    <Switch>
      <Route path="/" exact={true} component={Home} />
      <Route path="/search" component={Search} />
      <Route path="/searchresults" component={SearchResults} />
      <Route path="/recommendations" component={Recommendations} />
      <Route component={Home} />
    </Switch>
  );
}
