import C from '../constants';
import { combineReducers } from 'redux';
import { routerReducer as routing } from 'react-router-redux';

// Reducer functions here
export const product = (state = null, action) =>
    (action.type === C.ADD_PRODUCT) ? action.payload : state;

export const allProducts = (state = [], action) => {
    switch (action.type) {
        case C.ADD_PRODUCT:
            return [
                ...state,
                product(null, action)
            ];

        case C.BUY_PRODUCT:
            // Filters out product that has action.payload as ID
            return state.filter(product => product.id !== action.payload);

        default:
            return state;
    }
};

export default combineReducers({
    allProducts,
    routing
})