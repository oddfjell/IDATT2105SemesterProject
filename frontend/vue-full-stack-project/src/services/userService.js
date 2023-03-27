import axios from 'axios';
import router from "@/router";

const userApiClient = axios.create({
    baseURL: 'http://localhost:8080/users',
    headers: {
        'Content-Type': 'application/json'
    },
    withCredentials: true
});
function addHeader(token){
    return {
        headers: {
            "Authorization": "Bearer " + token
        },
    }
}

export default {
    getUsers(token) {
        return userApiClient.get('/', addHeader(token));
    },
    getJwtToken(values){
        return userApiClient.post('/service/login', values).catch((error) => {
                console.log(error.headers.text);
        });
    },
    /*registerUser(user){
        return userServiceApiClient.post('/register', user);
    },*/

    async registerUser(user) {
        try {
            const response = await userApiClient.post('/service/register', user);
            if(response.data != null){ //TODO send feilmedling og ta den imot
                await router.push("/login")
            } else{
                return "gal input"
            }
            //return response.data; //TODO her .data
        } catch (error) {
            console.error(error);
        }
    },
    async getUsername(username, token){
        let user
        try {
            user = await userApiClient.get('/getusername/' + username, addHeader(token))
        }catch (e){
            throw new Error();
        }
        return user
    },
    getUser(id, token){
        return userApiClient.get(`/${id}`, addHeader(token));
    },
    updateUser(user, token){
        return userApiClient.put('/updateUser', user, addHeader(token))
    },
    deleteUser(user, token){
        return userApiClient.delete(`/deleteUse`, user, addHeader(token))
    },
    isAdmin(user, token){
        return userApiClient.post(`/role`, user, addHeader(token))
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