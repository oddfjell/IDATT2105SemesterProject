<template>
  <back-header/>
  <div class="container">
    <h1>Sell a product</h1>
    <form id="registerItemField" @submit.prevent="submit">

      <BaseInput
          v-model="product.title"
          :modelValue="product.title"
          :error="errors.title"
          @input="onInputTitle"
          label="Product title"
          type="text"
          class="field"
      />
      <BaseInput
          v-model="product.price"
          :modelValue="product.price"
          :error="errors.price"
          @input="onInputPrice"
          label="Price"
          type="number"
          class="field"
      />
      <BaseInput
          v-model="product.briefDescription"
          :modelValue="product.briefDescription"
          :error="errors.briefDescription"
          @input="onInputBriefDescription"
          label="Brief Description"
          type="text"
          class="field"
      />
      <BaseInput
          v-model="product.description"
          :modelValue="product.description"
          :error="errors.description"
          @input="onInputDescription"
          label="Product info"
          type="text"
          class="field"
      />
      <ImagePicker/>
      <div class="Btn">
        <button id="registerProduct" type="submit">Sign in</button>
      </div>
    </form>
  </div>
</template>

<script>
import { useTokenStore } from "../stores/token";
import BaseInput from "@/components/Form/Input.vue";
import { useField, useForm } from "vee-validate";
import { string, object } from "yup";
import router from "@/router";
import BackHeader from "@/components/Header/backHeader.vue";
import ImagePicker from "@/components/Form/ImagePicker.vue";
export default {
  name: "LoginPageView.vue",
  components: {ImagePicker, BackHeader, BaseInput},
  data() {
    return {
      product: {
        title:String,
        price:Number,
        briefDescription:String,
        description:String,
        image:String
      },
    };
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
    const { value: title } = useField("title");
    const { value: price } = useField("price");
    const { value: briefDescription } = useField("briefDescription");
    const { value: description } = useField("description");
    const submit = handleSubmit(async (values) => {//TODO values??
      await tokenStore.getTokenAndSaveInStore(values); //this.user.username, this.user.passwordawait await asyncsetUserService.methods.sendUserLogin(values)
      if (tokenStore.jwtToken) {
        await router.push("/profile");
      } else {
        console.log("Login failed!")
        // this.loginStatus = "Login failed!" //TODO
      }

    });
    return {
      title,
      price,
      briefDescription,
      description,
      errors,
      submit,
      tokenStore
    };

  },
  methods: {
    onInputTitle(title) {
      this.title = title.target.value;
    },
    onInputPassword(price) {
      this.price = price.target.value;
    },
    onInputBriefDescription(briefDesc){
      this.briefDescription = briefDesc.target.value;
    },
    onInputDescription(desc){
      this.briefDescription=desc.target.value;
    },
    onRegister(){
      router.push("/register")
    }
  },
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