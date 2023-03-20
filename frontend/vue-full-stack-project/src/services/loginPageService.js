import axios from 'axios';
import router from "@/router";

const apiLoginService = axios.create({
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
                console.log(user)
                //const equationObject = { equation: screenText };
                //const requestBody = JSON.stringify(equationObject);
                const response = await apiLoginService.post('/login', user);

                if(response.data != null){
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
        }
    }
}