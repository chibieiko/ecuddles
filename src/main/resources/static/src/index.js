import React from 'react';
import { render } from 'react-dom';
import storeFactory from './store';
import { Provider } from 'react-redux';
import {Router, Route, IndexRoute} from 'react-router';
import {createBrowserHistory} from 'history';
import { syncHistoryWithStore } from 'react-router-redux';
import {App} from './components/';

const store = storeFactory();

// todo remove when app is ready
window.React = React;
window.store = store;

const history = syncHistoryWithStore(createBrowserHistory(), store);

render(
    <Provider store={store}>
        <Router history={ history }>
            <Route path="/" component={App}/>
        </Router>
    </Provider>,
    document.getElementById('react-container')
);