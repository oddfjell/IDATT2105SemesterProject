import axios from 'axios';

const apiClient = axios.create({
    baseURL: 'http://localhost:8080',
    headers: {
        'Content-Type': 'application/json',
    },
    withCredentials: true
});

export default {
    registerUser(user){
        return apiClient.post('/users', user);
    },
    getUsers() {
        return apiClient.get('/users/');
    },
    getUser(username){
        return apiClient.get(`/users/${username}`);
    }
};