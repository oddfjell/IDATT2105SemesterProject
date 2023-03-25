<template>
  <nav>
    <div id="routerList">
      <router-link class="navElement" to="/profile">Profile</router-link>
      <router-link class="navElement" to="/">Cart</router-link>
      <router-link  class="navElement" to="/newad">New ad</router-link>
      <router-link @click="logOut" class="navElement" to="/login">Log out</router-link>
    </div>
  </nav>
</template>

<script>
import {useTokenStore} from "@/stores/token";
import router from "@/router";

export default {
  name: "LoggedInNavBar",
  methods:{
    logOut(){
      const tokenStore = useTokenStore();
      tokenStore.logOut()
      router.push("/login")
    },
  },
}
</script>

<style scoped>
nav{
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}
#routerList{
  margin-right: 20px;
}
.navElement{
  float:right;
  display: block;
  color: white;
  text-align: center;
  padding: 15px 20px;
  text-decoration: none;
}
.navElement:hover{
  background-color: #555555;
}
</style>