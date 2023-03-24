import axios from 'axios';
import {useTokenStore} from "@/stores/token";

const userApiClient = axios.create({
    baseURL: 'http://localhost:8080/users',
    headers: {
        'Content-Type': 'application/json',
        "Authorization" : "Bearer " + useTokenStore().jwtToken
        //TODO header for username? nei
    },
    //withCredentials: true
});

const userServiceApiClient = axios.create({
    baseURL: 'http://localhost:8080/users/service',
    headers: {
        'Content-Type': 'application/json',
        "Authorization" : "Bearer " + useTokenStore().jwtToken
        //TODO header for username? nei
    },
    //withCredentials: true
});

export default {
    getUsers() {
        return userApiClient.get('/');
    },
    getJwtToken(values){
        return userServiceApiClient.post('/login', values);
    },
    registerUser(user){
        return userServiceApiClient.post('/register', user);
    },
    getUsername(username){ //TODO is logged in er her ja
        return userApiClient.get('/getusername', username);
    },/**
    getUser(username){
        return userApiClient.get(`/users/${username}`);
    },*/
    updateUser(user){
        return userApiClient.put('/updateUser', user)
    },
    deleteUser(user){
        return userApiClient.delete(`/deleteUse`, user)
    }
};

/**
 * Checks if the user exists in the database and returns a jwt token if
 * it exists. Is used to log in
 * @param values JSON-string
 * @returns {*} JSON-string
 */
/**
 * Checks if the user exists in the database and validates the accsess
 * by checking the validation from the jwt-token
 */