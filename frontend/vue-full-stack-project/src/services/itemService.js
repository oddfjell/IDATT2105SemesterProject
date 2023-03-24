import axios from 'axios';

const apiClient = axios.create({
    baseURL: 'http://localhost:8080',
    headers: {
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': 'http://localhost:8080',
    },
    withCredentials: true
});

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