<template>
  <form id="loginField" class="loginField" @submit.prevent>
    <div id="loginLabel" class="loginLabel">
      <label>Please login!</label>
    </div>
    <div id="username">
      <label id="usernameLabel" class="loginLabel">Username:</label>

      <input
          v-model="user.username"
          id="username"
          class="loginTextarea"
          @input="onInputUsername"
          type="text"
          required
      >
    </div>
    <div id="password">
      <label id="passwordLabel" class="loginLabel">Password: </label>
      <input
          v-model="user.password"
          id="password"
          class="loginTextarea"
          @input="onInputPassword"
          type="password"
          required
      >

     <button v-on:click="handleLoginClick" id="loginbutton" class="loginButton" type="submit">Sign in</button>
      <alert-box :popupData="popupData" ></alert-box>
    </div>
    <div>
      <p class="errorText">{{errorText}}</p>
    </div>
  </form>
</template>

<!--
<template>
  <input :type="passwordFieldType" v-model="password">
  <button type="password" @click="switchVisibility">show / hide</button>
</template>

<script>
export default {
  data() {
    return {
      password: "",
      passwordFieldType: "password"
    };
  },
  methods: {
    switchVisibility() {
      this.passwordFieldType = this.passwordFieldType === "password" ? "text" : "password";
    }
  }
};
</script> -->

<script>
//import setUserService from "@/services/setUserService";
import AlertBox from "@/components/AlertBox.vue";
import { useTokenStore } from "../stores/token";
import router from "@/router";
export default {
  name: "LoginPageView.vue",
  components: {AlertBox},
  data() {
    return {
      user: {
        password: "",
        username: ""
      },
      errorText: "",
      popupData : {
        "header" : "Login alert",
        "body" : "this user does not exist",
        "footer" : "--hilsen fugl.",
        "display" : "none"
      }
    };
  },
  setup() {
    const tokenStore = useTokenStore();
    return { tokenStore };
  },
  methods: {
    onInputUsername(username) {
      this.user.username = username.target.value;
      //this.$store.commit("UPDATE_NAME", e.target.value);
    },
    onInputPassword(password) {
      this.user.password = password.target.value;
    },
    async handleLoginClick() {

      if(this.user.username === "" || this.user.password === "") {
        console.log("oi")
      }else{


        await this.tokenStore.getTokenAndSaveInStore(this.user.username, this.user.password);
        if(this.tokenStore.jwtToken){
          await router.push("/profile");
        } else {
          console.log("Login failed!")
         // this.loginStatus = "Login failed!" //TODO
        }

        /*var login = await setUserService.methods.sendUserLogin(this.user);
        if(login !== null){
          this.popupData.display = "block";
        }*/
      }



      /**
       * //TODO let clean = DOMPurify.sanitize(dirty);  https://github.com/cure53/DOMPurify
      if(this.user.username === ""){//undefined
        //this.errorText.push("You must type a username to log in");
        //this.errorText = "You must type a username to log in"
      } else if(this.user.password === ""){
        //this.errorText.push("You must type a password to log in")
        //this.errorText = "You must type a password to log in"
      }else{
        //sett session tid og lagre bruker og session i store
        var login = await setUserService.methods.sendUserLogin(this.user);
        if(login !== null){
          this.popupData.display = "block";
        }
        //if (response != "") var response =
        //TODO feil innlogging
      }*/
    },



    /**checkForm: function (e) {
      //this.errors = [];

      if (!this.name) {
        this.errorText.push("Name required.");
      } else if ()
     if (!this.email) {
        this.errorText.push('Email required.');
      } else if (!this.validEmail(this.email)) {
        this.errorText.push('Valid email required.');
      }egen func da validEmail: function (email) {
      var re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
      return re.test(email);
    }

      if (!this.errors.length) {
        return true;
      }

      e.preventDefault();
    },*/



  },//TODO lag template for register med de samme attributene
  /*mounted(){
    this.popupData.display = "block";
  }*/
}
</script>

<style scoped>
.loginField{
  max-width: 420px;
  margin: 30px auto;
  background: white;
  text-align: left;
  padding: 40px;
  border-radius: 10px;
}
.loginLabel{
  color: #1b1a1a;
  display: inline-block;
  margin: 25px 0 15px;
  font-size: 0.6em;
  text-transform: uppercase;
  letter-spacing: 1px;
  font-weight: bold;
}
.loginTextarea{
  display: block;
  padding: 10px 6px;
  width: 100%;
  box-sizing: border-box;
  border: none;
  border-bottom: 1px solid #ddd;
  color: #555;
  height: auto;
  max-width: 100%;
}
.loginButton{
  background: #0b6dff;
  border: 0;
  padding: 10px 20px;
  margin-top: 20px;
  color: white;
  border-radius: 20px;
}
</style>