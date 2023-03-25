//import axios from "axios";
import { defineStore } from "pinia";
//import {getJwtToken} from "@/services/tokenService"

import userService from "@/services/userService";

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
                let response = await userService.getJwtToken(values);//valuesusername, password
                let data = response.data;
                if(data != null && data != '' && data != undefined){
                    this.jwtToken = data;
                    this.loggedInUser = values.username/// username /TODO user
                    console.log(this.loggedInUser)
                }
            } catch (err){
                console.log(err)
            }
        },
        logOut(){
            this.jwtToken=null;
            this.loggedInUser=null;
        }
    },
});
