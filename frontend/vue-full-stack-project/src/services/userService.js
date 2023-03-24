import axios from 'axios';
import {useTokenStore} from "@/stores/token";

const userApiClient = axios.create({
    baseURL: 'http://localhost:8080',
    headers: {
        'Content-Type': 'application/json',
        "Authorization" : "Bearer " + useTokenStore().jwtToken
        //TODO header for username? nei
    },
    //withCredentials: true
});

export default {
    /*registerUser(user){
        return userApiClient.post('/users', user);
    },*/
    getUsers() {
        return userApiClient.get('/users/');
    },
    getUser(username){
        return userApiClient.get(`/users/${username}`);
    },/*
    updateUser(){
        return userApiClient
    },*/
    deleteUser(username){
        return userApiClient.delete(`/users/${username}`)
    }
};

export const registerUser = (values) => {
    const config = {
        headers: {
            "Content-type": "application/json"
        },
    }; //TODO fix endpoint
    //TODO bare logg rett inn
    return axios.post("http://localhost:8080/createuser", values, config);
}