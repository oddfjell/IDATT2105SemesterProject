<template>
  <Header />
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
      <BaseInput v-model="product.image"
                 :model-value="product.image"
                 :error="errors.image"
                 @input="onInputImage"
                 label="URL to an image"
                 type="text"
                 class="field"
      />

      <div class="Btn">
        <button id="publishBtn" class="Btn" type="submit">Publish product</button>
      </div>
    </form>
  </div>
</template>

<script>
import { useTokenStore } from "@/stores/token";
import BaseInput from "@/components/Form/Input.vue";
import { useField, useForm } from "vee-validate";
import {string, object, number} from "yup";
import BackHeader from "@/components/Header/backHeader.vue";
import MultiImagePicker from "@/components/Form/MultiImagePicker.vue";
import itemService from "@/services/itemService";
import Header from "@/components/Header/Header.vue";
import userService from "@/services/userService";
export default {
  name: "LoginPageView.vue",
  components: {MultiImagePicker, BackHeader, BaseInput, Header},
  data() {
    return {
      product: {
        title:"",
        price:number,
        briefDescription:"",
        description:"",
        image:"",
        user:null,
      },
    };
  },
  setup() {
    const tokenStore = useTokenStore();

    const validationSchema = object({
      title: string("Wrong format").required("Cannot be empty"),
      price: number("Wrong format").required("Cannot be empty"),
      briefDescription: string("Wrong format").required("Cannot be empt"),
      description: string("Wrong format").required("Cannot be empty"),
      image: string().required("The item should have a URL to a image")
    });
    const { handleSubmit, errors } = useForm({
      validationSchema,
    });
    const { value: title } = useField("title");
    const { value: price } = useField("price");
    const { value: briefDescription } = useField("briefDescription");
    const { value: description } = useField("description");
    const { value: image } = useField("image");
    const submit = handleSubmit(async (values) => {
      if (tokenStore.jwtToken) {
        await itemService.publishItem(values, tokenStore.jwtToken)
      } else {
        console.log("You dont have a token!")
      }

    });
    return {
      title,
      price,
      briefDescription,
      description,
      image,
      errors,
      submit,
      tokenStore
    };

  },
  async mounted() {
    if(this.tokenStore.jwtToken) {
      let response
      try {
        response = await userService.getUsername(this.tokenStore.loggedInUser, this.tokenStore.jwtToken);//, this.tokenStore.jwtToken
      }catch (e){
        console.log(e)
        this.tokenStore.logOut()
      }
      this.user = response.data;//TODO
    }
  },
  methods: {
    onInputTitle(title) {
      this.title = title.target.value;
    },
    onInputPrice(price) {
      this.price = price.target.value;
    },
    onInputBriefDescription(briefDesc){
      this.briefDescription = briefDesc.target.value;
    },
    onInputDescription(desc){
      this.description=desc.target.value;
    },
    onInputImage(image){
      this.image=image.target.value;
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
#publishBtn{
  background: #0b6dff;
  border: 0;
  padding: 10px 20px;
  width: 80%;
  color: white;
  border-radius: 5px;
}

#publishBtn:hover{
  background-color: #4169a8;
  cursor: pointer;
}

</style>