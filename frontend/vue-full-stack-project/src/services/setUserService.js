import axios from 'axios';
import router from "@/router";

const apiUserService = axios.create({
    baseURL: 'http://localhost:8080',
    headers: {
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': 'http://localhost:8080'
    }
})

/**
 * Sender stringen i en JSON-body og tar imot svaret
 */
export default {
    methods: {
        async sendUserLogin(user) {
            try {
                const response = await apiUserService.post('/login', user);
                if(response.data != null){ //TODO send feilmedling og ta den imot
                    //session og user
                    // store ting
                    await router.push("/profile")
                } else{
                    return "this user does not exist"
                }
                console.log(response);
                console.log(response.data);
                //return response.data; //TODO her .data

            } catch (error) {
                console.error(error);
            }
        },
        async sendUserRegister(user) {
            try {
                const response = await apiUserService.post('/register', user);
                if(response.data != null){ //TODO send feilmedling og ta den imot
                    await router.push("/profile")
                } else{
                    return "gal input"
                }
                console.log(response);
                console.log(response.data);
                //return response.data; //TODO her .data
            } catch (error) {
                console.error(error);
            }
        }
    }
}