import axios from 'axios';

const apiClient = axios.create({
    baseURL: 'http://localhost:8080',
    headers: {
        'Content-Type': 'application/json',
    },
    withCredentials: true
});

export default {
    publishItem(item){
        return apiClient.post('/item', item);
    },
    async getItems() {
        return await apiClient.get('/getitems/');
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