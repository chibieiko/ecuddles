import C from './constants';
import fetch from 'isomorphic-fetch';



export const addProduct = (id, name) => ({
    type: C.ADD_PRODUCT,
    payload: {
        id,
        name
    }
});

export const buyProduct = (id) => ({
    type: C.BUY_PRODUCT,
    payload: id
});