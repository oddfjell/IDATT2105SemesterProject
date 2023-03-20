<template>
  <div id="loginField" class="loginField">
    <div id="loginLabel" class="loginLabel">
      <label>Please login!</label>
    </div>
    <div id="username">
      <label id="usernameLabel" class="loginLabel">Username:</label>
      <textarea v-model="user.username" id="username" class="loginTextarea" @input="onInputUsername"></textarea>
    </div>
    <div id="password">
      <label id="passwordLabel" class="loginLabel">Password: </label>
      <textarea v-model="user.password" id="password" class="loginTextarea" @input="onInputPassword"></textarea>
      <button v-on:click="handleLoginClick" id="loginbutton" class="loginButton">Sign in</button>
    </div>
    <div>
      <p class="errorText">{{errorText}}</p>
    </div>
  </div>
</template>

<script>
//import loginCheckAuthentication from "../middlewares/loginCheckAuthentication";
import loginPageService from "@/services/loginPageService";
export default {
  name: "LoginPageView.vue",
  data() {
    return {
      user: {
        password: "",
        username: ""
      },
      errorText: ""
    };
  },
  methods: {
    onInputUsername(username) {
      this.user.username = username.target.value;
      console.log(this.user.username + " " + this.user.password)
      //this.$store.commit("UPDATE_NAME", e.target.value);
    },
    onInputPassword(password) {
      this.user.password = password.target.value;
      console.log(this.user.username + " " + this.user.password)
    },
    async handleLoginClick() {
      //TODO let clean = DOMPurify.sanitize(dirty);  https://github.com/cure53/DOMPurify
      if(this.user.username === ""){//undefined
        this.errorText = "You must type a username to log in"
      } else if(this.user.password === ""){
        this.errorText = "You must type a password to log in"
      }else{
        //sett session tid og lagre bruker og session i store
        await loginPageService.methods.sendUserLogin(this.user);
        //TODO feil innlogging
      }
    },
  },//TODO lag template for register med de samme attributene
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
.errorText{
  color: #ff0062;
  margin-top: 10px;
  font-size: 0.8em;
  font-weight: bold;
}
</style>