<template>
  <div id="loginField" class="loginField">
    <div id="loginLabel" class="loginLabel">
      <label>Please login!</label>
    </div>
    <div id="username">
      <label id="usernameLabel" class="loginLabel">Username:</label>
      <textarea v-model="username" id="username" class="loginTextarea"></textarea>
    </div>
    <div id="password">
      <label id="passwordLabel" class="loginLabel">Password: </label>
      <textarea v-model="password" id="password" class="loginTextarea"></textarea>
      <button v-on:click="handleLoginClick" id="loginbutton" class="loginButton">Sign in</button>
      <!--<label id="loginstatusLabel" class="loginLabel">{{ loginStatus }}</label>-->
    </div>
    <div>
      <p>{{loginText}}</p>
    </div>
  </div>

</template>

<script>
export default {
  name: "LoginPageView.vue",
  data() {
    return {
      username: "",
      password: "",
      //loginStatus: "",
      loginText: ""
    };
  },
  methods: {
    async handleLoginClick() {

      //TODO let clean = DOMPurify.sanitize(dirty);  https://github.com/cure53/DOMPurify
      this.loginText = this.username + " " + this.password
      console.log("hello world")


      //if("sjekk for gyldige felt"){
      //send data og få svar:  let response = await loginRequest({})  ||  SentFeedbackService.postFeedback(this.feedB).then(() => {}).catch((error) => {console.log(error);});
      //sett session tid og lagre bruker og session i store
      /*
      if(isLoginSuccessful(response)){
        router.push("/home");
      } else {
        this.loginStatus = "Login failed!"
      }*/
    },
  },
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