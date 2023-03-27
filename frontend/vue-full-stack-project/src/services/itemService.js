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
    return {
        headers: {
            "Content-type": "application/json",
            "Authorization": "Bearer " + token
        },
    }
}
//TODO denne er ooof ja

export default {
    async publishItem(item, token){
        return await itemApiClient.post('/createitem', item, addHeader(token));
    },
    async getItems() {
        let response = await itemServiceApiClient.get('/getitems');
        return response.data
    },
    async getItemByID(id, token){
        let response = await itemApiClient.get(`/${id}`, addHeader(token));
        return response.data
    },
    async deleteItem(id,token){
    }
};