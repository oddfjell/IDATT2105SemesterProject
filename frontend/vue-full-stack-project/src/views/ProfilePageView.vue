<template>
  <Header />
  <div>
    <div v-if="user" id="mainContainer">
      <h2>Hey, {{ user.username }}</h2>
      <label id="homepageTitle">Welcome to the home screen</label>

      <p>:)</p>
      <!--<div class="container">
        <div>
          <div id="profilePicture">
            <img alt="bird" src="https://ctl.s6img.com/society6/img/T4B1_3uYoossKHshTuH-AWt3I2I/w_1500/prints/~artwork/s6-original-art-uploads/society6/uploads/misc/dd1abcfa933c48e982c730c3cc154cf2/~~/yellow-red-lovebird-lovebird-bird-pets-cute-cute-bird-yellow-lovebird-yellow-bird-prints.jpg">
          </div>
          <label>Eg heitar Hans</label>
        </div>
        <div id="item_grid">
          <div class="item" @click="bop" :key="item" v-for="item in items">
            <ItemComponent/>
          </div>
        </div>
      </div>-->



    </div>
    <div v-if="!user">
      <h2>Unauthorized!!!</h2>
    </div>
  </div>



</template>

<script>
//import ItemComponent from "@/components/Item.vue";  //TODO fiks duplikat kode og lag heller flere templates
import { useTokenStore } from "../stores/token";
//import {isUserLoggedIn} from "../services/tokenService"
import userService from "@/services/userService";
import Header from "@/components/Header/Header.vue";

export default {
  name: "ProfilePageView.vue",
  components: { Header},
  setup() {
    const tokenStore = useTokenStore();
    return { tokenStore };
  },
  async mounted() {
    if(!this.tokenStore.jwtToken) {
      console.log("Unauthenticated context");
    } else {
      console.log("Authenticated context");
      let response  = await userService.getUsername(this.tokenStore.loggedInUser, this.tokenStore.jwtToken);//, this.tokenStore.jwtToken
          //isUserLoggedIn(this.tokenStore.loggedInUser, this.tokenStore.jwtToken);
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
  created() {
    this.items=[1,2,3,4,5]
  }
}
</script>

<style scoped>
.container{
  padding: 10px;
  border-radius: 5px;
  border: solid black 4px;
  display: grid;
  justify-items: center;
  grid-template-columns: 1fr 1fr;
}
img{
  width: 100%;
}

#item_grid{
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-gap: 5%;
}
.item:hover{
  margin: 20px;
}
</style>