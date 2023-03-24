import axios from 'axios';
import {useTokenStore} from "@/stores/token";
import router from "@/router";

const userApiClient = axios.create({
    baseURL: 'http://localhost:8080/users',
    headers: {
        'Content-Type': 'application/json',
        "Authorization" : "Bearer " + useTokenStore().jwtToken
    },
    //withCredentials: true
});

const userServiceApiClient = axios.create({
    baseURL: 'http://localhost:8080/users/service',
    headers: {
        'Content-Type': 'application/json'
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
    /*registerUser(user){
        return userServiceApiClient.post('/register', user);
    },*/

    async registerUser(user) {
        try {
            const response = await userServiceApiClient.post('/register', user);
            if(response.data != null){ //TODO send feilmedling og ta den imot
                await router.push("/profile")
            } else{
                return "gal input"
            }
            //return response.data; //TODO her .data
        } catch (error) {
            console.error(error);
        }
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