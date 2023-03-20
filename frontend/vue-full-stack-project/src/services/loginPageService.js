import axios from 'axios'

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
        async sendEquation(screenText) {
            try {
                const equationObject = { equation: screenText };
                const requestBody = JSON.stringify(equationObject);
                const response = await apiLoginService.post('/calculate', requestBody);

                console.log(response);
                console.log(response.data);

                return response.data; //TODO her .data

            } catch (error) {
                console.error(error);
            }
        }
    }
}