//import axios from "axios";
import { defineStore } from "pinia";
import {getJwtToken} from "@/services/httpService"

export const useTokenStore = defineStore("token", {
    state: () => ({
        jwtToken: null,
        loggedInUser: null,
    }),
    persist: {
        storage: sessionStorage, // note that data in sessionStorage is cleared when the page session ends
    },

    actions: {
        async getTokenAndSaveInStore(username, password) {
            try{
                let response = await getJwtToken(username, password);

                console.log(response)
                console.log(response.data)

                let data = response.data;
                if(data != null && data != '' && data != undefined){
                    this.jwtToken = data;
                    this.loggedInUser = username //TODO user

                    console.log(this.jwtToken + this.loggedInUser)
                }
            } catch (err){
                console.log(err)
            }
        }
    },
});
