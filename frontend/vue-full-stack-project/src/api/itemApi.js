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