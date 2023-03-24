//import axios from "axios";
import { defineStore } from "pinia";
import {getJwtToken} from "@/services/tokenService"

export const useTokenStore = defineStore("token", {
    state: () => ({
        jwtToken: null,
        loggedInUser: null,
    }),
    persist: {
        storage: sessionStorage, // note that data in sessionStorage is cleared when the page session ends
    },

    actions: {
        async getTokenAndSaveInStore(values) { ///username, password
            try{
                let response = await getJwtToken(values);//valuesusername, password

                console.log("yo")
                console.log(response)
                console.log(response.data)

                let data = response.data;
                if(data != null && data != '' && data != undefined){
                    this.jwtToken = data;
                    this.loggedInUser = values.at(0)/// username /TODO user

                    console.log(this.jwtToken + this.loggedInUser)
                }
            } catch (err){
                console.log(err)
            }
        }
    },
});
