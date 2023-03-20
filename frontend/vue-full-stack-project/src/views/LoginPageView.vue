<template>
  <div id="loginField">
    <div id="loginLabel">
      <label>Please login!</label>
    </div>
    <div id="username">
      <label id="usernameLabel">Username:</label>
      <textarea v-model="username" id="username"></textarea>
    </div>
    <div id="password">
      <label id="passwordLabel">Password: </label>
      <textarea v-model="password" id="password"></textarea>
      <button v-on:click="handleLoginClick" id="loginbutton">Sign in</button>
      <label id="loginstatusLabel">{{ loginStatus }}</label>
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
      loginStatus: "",
      loginText: ""
    };
  },
  methods: {
    async handleLoginClick() {
      //TODO let clean = DOMPurify.sanitize(dirty);  https://github.com/cure53/DOMPurify
      this.loginText = this.username + " " + this.password + " " + this.loginStatus
      /*let response = await loginRequest({})
      if(isLoginSuccessful(response)){
        router.push("/home");
      } else {
        this.loginStatus = "Login failed!"
      }*/
      console.log("hello world")
    },
  },
}
</script>

<style scoped>

</style>