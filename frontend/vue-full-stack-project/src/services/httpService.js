import axios from "axios";

export const getJwtToken = (values) => {//username, password
    const config = {
        headers: {
            "Content-type": "application/json",
        },
    };
    return axios.post("http://localhost:8080/token", values, config);//TODO JSON.stringify({ username: username, password: password })
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
