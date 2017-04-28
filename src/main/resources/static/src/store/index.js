import appReducer from './reducers';
import thunk from 'redux-thunk';
import { createStore, applyMiddleware } from 'redux';

export default () => {
    return applyMiddleware(thunk)(createStore)(appReducer)
}