<template>
  <div class="container">
    <h1>Register</h1>
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
      v-model="user.email"
      :modelValue="user.email"
      :error="errors.email"
      @input="onInputEmail"
      label="Email"
      type="email"
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
        <button id="registerBtn" v-on:click="handleRegisterClick" type="submit">Register</button>
      </div>
    </form>
    <div class="Btn">
      <button id="loginBtn" @click="onLogin" >Already have an account? Log in here!</button>
    </div>
  </div>
</template>

<script>
import setUserService from "@/services/setUserService";
import BaseInput from "@/components/Form/Input.vue";
import { useField, useForm } from "vee-validate";
import { string, object } from "yup";
import router from "@/router";
export default {
  name: "RegisterPageView.vue",
  components: {BaseInput},
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
      this.username = username.target.value;
      //this.$store.commit("UPDATE_NAME", e.target.value);
    },
    onInputEmail(email) {
      this.email = email.target.value;
    },
    onInputPassword(password) {
      this.password = password.target.value;
    },
    onLogin(){
      router.push("/login")
    }
  },
  setup() {
    const validationSchema = object({
      username: string("Wrong format").required("Cannot be empty"),
      email: string("Wrong format").email("Please enter a valid email").required("Cannot be empty"),
      password: string("Wrong format").required("Cannot be empty"),
    });
    const {handleSubmit, errors} = useForm({
      validationSchema,
    });
    const {value: username} = useField("username");
    const {value: email} = useField("email");
    const {value: password} = useField("password");
    const submit = handleSubmit((values) => {
      setUserService.methods.sendUserLogin(values)
    });
    return {
      username,
      email,
      password,
      errors,
      submit,
    };
  }
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
#registerBtn{
  background: #0b6dff;
  border: 0;
  padding: 10px 20px;
  width: 80%;
  color: white;
  border-radius: 5px;
}
#loginBtn{
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