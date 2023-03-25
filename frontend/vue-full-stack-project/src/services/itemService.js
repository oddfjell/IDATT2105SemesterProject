//Access-Control-Allow-Origin': 'http://localhost:8080'},withCredentials: true
import axios from 'axios';

const itemApiClient = axios.create({
    baseURL: 'http://localhost:8080/item',
    headers: {
        'Content-Type': 'application/json',
    },
    //withCredentials: true
});
const itemServiceApiClient = axios.create({
    baseURL: 'http://localhost:8080/item/service',
    headers: {
        'Content-Type': 'application/json'
    },
    withCredentials: true
});

function addHeader(token){
    const config ={
        headers: {
            "Content-type": "application/json",
            "Authorization": "Bearer " + token
        },
    }
    return config
}
//TODO denne er ooof ja

export default {
    async publishItem(item, token){
        let response = await itemApiClient.post('/createitem', item, addHeader(token))
        return response;
    },
    async getItems() {
        let response = await itemServiceApiClient.get('/getitems');
        return response.data
    },/**
    getItemByID(id){
        return itemApiClient.get(`/item/${id}`);
    }*/
};