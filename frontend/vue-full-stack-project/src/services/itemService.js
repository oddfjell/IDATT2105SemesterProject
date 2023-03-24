//Access-Control-Allow-Origin': 'http://localhost:8080'},withCredentials: true
import axios from 'axios';
import {useTokenStore} from "@/stores/token";

const itemApiClient = axios.create({
    baseURL: 'http://localhost:8080/item',
    headers: {
        'Content-Type': 'application/json',
        "Authorization" : "Bearer " + useTokenStore().jwtToken
    },
    //withCredentials: true
});

const itemServiceApiClient = axios.create({
    baseURL: 'http://localhost:8080/users/item/service',
    headers: {
        'Content-Type': 'application/json'
    },
    //withCredentials: true
});

//TODO denne er ooof ja

export default {
    async publishItem(item){
        let response = await itemServiceApiClient.post('/createitem', item)
        return response;
    },
    async getItems() {
        let response = await itemApiClient.get('/getitems');
        return response.data
    },/**
    getItemByID(id){
        return itemApiClient.get(`/item/${id}`);
    }*/
};