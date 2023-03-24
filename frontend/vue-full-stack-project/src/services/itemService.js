import axios from 'axios';

const apiClient = axios.create({
    baseURL: 'http://localhost:8080',
    headers: {
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': 'http://localhost:8080',
    },
    withCredentials: true
});

//TODO denne er ooof ja

export default {
    async publishItem(item){
        let response = await apiClient.post('/createitem', item)
        return response;
    },
    async getItems() {
        let response = await apiClient.get('/getitems');
        return response.data
    },
    getItemByID(id){
        return apiClient.get(`/item/${id}`);
    }
};


export const publishItem = (item, token) => { //valid token sjekk
    const config = {
        headers: {
            "Content-type": "application/json",
            "Authorization" : "Bearer " + token
        },
    };
    return axios.post('http://localhost:8080/item', item, config);
}