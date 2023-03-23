import axios from "axios";

export const getJwtToken = (username, password) => {
    const config = {
        headers: {
            "Content-type": "application/json",
        },
    };
    return axios.post("http://localhost:8080/token", JSON.stringify({ username: username, password: password }), config);
}
export const getUserInfo = (username, token) => {
    const config = {
        headers: {
            "Content-type": "application/json",
            "Authorization" : "Bearer " + token
        },
    };
    return axios.get("http://localhost:8080/users/"+username, config);
}
