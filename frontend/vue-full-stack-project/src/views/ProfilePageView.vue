<template>
    <Header />
    <back-header tabindex="1" />
    <div v-if="user" id="profile-page">
      <div id="image">
        <img v-if="user.image" :src="user.image" alt="">
        <img v-else src="/icons/defaultPfp.png" alt="">
      </div>
    <div id="name"><h1>{{name}}</h1></div>
      <div class="container" id="info">
        <ul>
          <li>Email : {{user.email}}</li>
          <li>Phone number: {{user.phoneNumber}}</li>
          <li>Date of birth: {{user.dateOfBirth}}</li>
          <li>Registered: {{user.registered}}</li>
        </ul>
      </div>
    </div>
  <div v-else>
    <h2>You are not logged in ...</h2>
  </div>
  </template>

<script>
//import ItemComponent from "@/components/Item.vue";  //TODO fiks duplikat kode og lag heller flere templates
import { useTokenStore } from "@/stores/token";
//import {isUserLoggedIn} from "../services/tokenService"
import userService from "@/services/userService";
import Header from "@/components/Header/Header.vue";
import BackHeader from "@/components/Header/backHeader.vue";

export default {
  name: "ProfilePageView.vue",
  components: { Header, BackHeader},
  setup() {
    const tokenStore = useTokenStore();
    return { tokenStore };
  },
  async mounted() {
    if(this.tokenStore.jwtToken) {
      let response
      try {
        response = await userService.getUsername(this.tokenStore.loggedInUser, this.tokenStore.jwtToken);//, this.tokenStore.jwtToken
      }catch (e){
        console.log(e)
        this.tokenStore.logOut()
      }
      this.user = response.data;//TODO
    }
  },
  data(){
    return{
      user: null,
      props:{
        items:Array
      },
    }
  },
  computed:{
    name(){
      return this.user.firstName +" " + this.user.lastName
    }
}
}
</script>

<style scoped>
#profile-page{
  width: 60%;
  margin: auto auto 5%;
}
#image img{
  width: 30%;
}
#image{
  text-align: center;
}
#name{
  text-align: center;
}
</style>