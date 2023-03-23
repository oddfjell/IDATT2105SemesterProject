<template>
  <back-header/>
  <div class="container">
    <h1>Log in</h1>
  <form id="loginField" class="loginField" @submit.prevent="submit">

    <BaseInput
        v-model="user.username"
        :modelValue="user.username"
        :error="errors.username"
        @input="onInputUsername"
        label="Username"
        type="text"
        class="field"
    />
    <BaseInput
        v-model="user.password"
        :modelValue="user.password"
        :error="errors.password"
        @input="onInputPassword"
        label="Password"
        type="password"
        class="field"
    />
    <div class="Btn">
     <button id="loginBtn" v-on:click="handleLoginClick" type="submit">Sign in</button>
    </div>
      <alert-box :popupData="popupData" ></alert-box>
  </form>
    <div class="Btn">
      <button id="registerBtn" @click="onRegister" >Dont have an account? Register here!</button>
    </div>
  </div>
</template>

<script>
import { useTokenStore } from "../stores/token";
//import setUserService from "@/services/setUserService";
import AlertBox from "@/components/AlertBox.vue";
import BaseInput from "@/components/Form/Input.vue";
import { useField, useForm } from "vee-validate";
import { string, object } from "yup";
import router from "@/router";
import BackHeader from "@/components/Header/backHeader.vue";

export default {
  name: "LoginPageView.vue",
  components: {BackHeader, BaseInput, AlertBox},
  data() {
    return {
      password: "",
      passwordFieldType: "password",
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
      },
    };
  },
  
  methods: {
    switchVisibility() {
      this.passwordFieldType = this.passwordFieldType === "password" ? "text" : "password";
    },
    onInputUsername(username) {
      this.user.username = username.target.value;
      //this.$store.commit("UPDATE_NAME", e.target.value);
    },
    onInputPassword(password) {
      this.user.password = password.target.value;
    },
    onRegister(){
      router.push("/register")
    }
    /*
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
    },*/
  },
  
  setup() {
    const tokenStore = useTokenStore();    
    const validationSchema = object({
      username: string("Wrong format").required("Cannot be empty"),
      password: string("Wrong format").required("Cannot be empty"),
    });
    const { handleSubmit, errors } = useForm({
      validationSchema,
    });
    const { value: username } = useField("username");
    const { value: password } = useField("password");
    const submit = handleSubmit((values) => {
      setUserService.methods.sendUserLogin(values)
    });
    return {
      username,
      password,
      errors,
      submit,
      { tokenStore }
    };

  },
  
  /*mounted(){
    this.popupData.display = "block";
  }*/
}
</script>

<style scoped>
.field{
  display: block;
  width: 80%;
  margin: 10px auto;
}

.Btn{
  margin: 20px auto;
  text-align: center;
}
#loginBtn{
  background: #0b6dff;
  border: 0;
  padding: 10px 20px;
  width: 80%;
  color: white;
  border-radius: 5px;
}
#registerBtn{
  background: #b7b7b7;
  border: 0;
  padding: 10px 20px;
  width: 60%;
  color: black;
  border-radius: 5px;
}
#loginBtn:hover{
  background-color: #4169a8;
  cursor: pointer;
}
#registerBtn:hover{
  background-color: #d0cece;
  cursor: pointer;
}
</style>