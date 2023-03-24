import axios from "axios";

/**
 * Checks if the user exists in the database and returns a jwt token if
 * it exists. Is used to log in
 * @param values JSON-string
 * @returns {*} JSON-string
 */
export const getJwtToken = (values) => {//username, password //TODO dette er login request
    const config = {
        headers: {
            "Content-type": "application/json",
        },
    };
    return axios.post("http://localhost:8080/token", values, config);//TODO JSON.stringify({ username: username, password: password })
}
/**
 * Checks if the user exists in the database and validates the accsess
 * by checking the validation from the jwt-token
 */
export const isUserLoggedIn = (username, token) => { //valid token sjekk
    const config = {
        headers: {
            "Content-type": "application/json",
            "Authorization" : "Bearer " + token
        },
    }; //TODO fix endpoint
    return axios.get("http://localhost:8080/users/"+username, config);
    //TODO lag alle
}



