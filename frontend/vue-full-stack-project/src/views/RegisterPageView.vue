<template>
  <div id="registerField" class="registerField">
    <div id="registerLabel" class="registerLabel">
      <label>Please register!</label>
    </div>
    <div id="username">
      <label id="usernameLabel" class="registerLabel">Username:</label>
      <textarea v-model="user.username" id="username" class="registerTextarea" @input="onInputUsername"></textarea>
    </div>
    <div id="email">
      <label id="emailLabel" class="registerLabel">Email:</label>
      <textarea v-model="user.email" id="email" class="registerTextarea" @input="onInputEmail"></textarea>
    </div>
    <div id="password">
      <label id="passwordLabel" class="registerLabel">Password: </label>
      <textarea v-model="user.password" id="password" class="registerTextarea" @input="onInputPassword"></textarea>
      <button v-on:click="handleRegisterClick" id="registerbutton" class="registerButton">Sign in</button>
    </div>
    <div>
      <p class="errorText">{{errorText}}</p>
    </div>
  </div>
</template>

<script>
import setUserService from "@/services/setUserService";
export default {
  name: "RegisterPageView.vue",
  data() {
    return {
      user: {
        email: "",
        password: "",
        username: ""
      },
      errorText: ""
    };
  },
  methods: {
    onInputUsername(username) {
      this.user.username = username.target.value;
      //this.$store.commit("UPDATE_NAME", e.target.value);
    },
    onInputEmail(email) {
      this.user.email = email.target.value;
    },
    onInputPassword(password) {
      this.user.password = password.target.value;
    },
    async handleRegisterClick() {
      //TODO let clean = DOMPurify.sanitize(dirty);  https://github.com/cure53/DOMPurify
      if(this.user.username === ""){//undefined
        this.errorText = "You must type a username to register"
      } else if(this.user.email === ""){
        this.errorText = "You must type a email to register"
      } else if(this.user.password === ""){
        this.errorText = "You must type a password to register"
      }else{
        //sett session tid og lagre bruker og session i store
        await setUserService.methods.sendUserRegister(this.user);
        //TODO feil innlogging
      }
    },
  },//TODO lag template for register med de samme attributene
}
</script>

<style scoped>
.registerField{
  max-width: 420px;
  margin: 30px auto;
  background: white;
  text-align: left;
  padding: 40px;
  border-radius: 10px;
}
.registerLabel{
  color: #1b1a1a;
  display: inline-block;
  margin: 25px 0 15px;
  font-size: 0.6em;
  text-transform: uppercase;
  letter-spacing: 1px;
  font-weight: bold;
}
.registerTextarea{
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
.registerButton{
  background: #0b6dff;
  border: 0;
  padding: 10px 20px;
  margin-top: 20px;
  color: white;
  border-radius: 20px;
}
</style>