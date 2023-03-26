//Access-Control-Allow-Origin': 'http://localhost:8080'},withCredentials: true
import axios from 'axios';

const testApiClient = axios.create({
    baseURL: 'http://localhost:8080/test'
    //withCredentials: true
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
    async test(username, token){
        console.log("halla")
        let response = await testApiClient.post('/' + username, addHeader(token))
        return response;
    }
};