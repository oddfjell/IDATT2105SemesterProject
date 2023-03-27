<template>
  <Header/>
  <back-header/>
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
          v-model="user.password"
          :modelValue="user.password"
          :error="errors.password"
          @input="onInputPassword"
          label="Password"
          type="password"
          class="field"
      />

      <div id="name" class="field">
        <BaseInput
            v-model="user.firstName"
            :modelValue="user.firstName"
            :error="errors.first_name"
            @input="onInputFirstname"
            label="Firstname"
            type="text"
        />

        <BaseInput
            v-model="user.lastName"
            :modelValue="user.lastName"
            :error="errors.last_name"
            @input="onInputLastname"
            label="Lastname"
            type="text"
        />

      </div>

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
          v-model="user.phoneNumber"
          :modelValue="user.phoneNumber"
          :error="errors.phoneNumber"
          @input="onInputPhone"
          label="Phone number"
          type="number"
          class="field"
      />

      <BaseInput
          v-model="user.dateOfBirth"
          :modelValue="dateOfBirth"
          :error="errors.dateOfBirth"
          @input="onInputDateOfBirth"
          label="Date of birth"
          type="date"
          class="field"
      />

      <BaseInput
          v-model="user.address.city"
          :modelValue="user.address.city"
          :error="errors.city"
          @input="onInputCity"
          label="City"
          type="text"
          class="field"
      />

      <BaseInput
          v-model="user.address.country"
          :modelValue="user.address.country"
          :error="errors.country"
          @input="onInputCountry"
          label="Country"
          type="text"
          class="field"
      />

      <BaseInput
          v-model="user.address.postalCode"
          :modelValue="user.address.postalCode"
          :error="errors.postalCode"
          @input="onInputPostalCode"
          label="Postal code"
          type="number"
          class="field"
      />

      <BaseInput
          v-model="user.address.streetName"
          :modelValue="user.address.streetName"
          :error="errors.streetName"
          @input="onInputStreetName"
          label="Street name"
          type="text"
          class="field"
      />

      <BaseInput
          v-model="user.address.streetNumber"
          :modelValue="user.address.streetNumber"
          :error="errors.streetNumber"
          @input="onInputStreetNumber"
          label="Street number"
          type="text"
          class="field"
      />

      <ImagePicker label="Profile picture" class="field"/>
      <div class="Btn">
        <button id="registerBtn" type="submit">Register</button>
      </div>
    </form>
    <div class="Btn">
      <button id="loginBtn" @click="onLogin">Already have an account? Log in here!</button>
    </div>
  </div>
</template>

<script>
//import setUserService from "@/services/setUserService";
import userService from "@/services/userService";
import BaseInput from "@/components/Form/Input.vue";
import {useField, useForm} from "vee-validate";
import {string, object, date, number} from "yup";
import router from "@/router";
import BackHeader from "@/components/Header/backHeader.vue";
import ImagePicker from "@/components/Form/ImagePicker.vue";
import Header from "@/components/Header/Header.vue";

export default {
  name: "RegisterPageView.vue",
  components: {ImagePicker, BackHeader, BaseInput, Header},
  data() {
    return {
      user: {
        username: "",
        password: "",
        firstName: "",
        lastName: "",
        email: "",
        phoneNumber: number,
        dateOfBirth: date,
        registered: date,
        image: "",
        address: {
          city: "",
          country: "",
          postalCode: number,
          streetName: "",
          streetNumber: ""
        }
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
    onInputFirstname(firstname) {
      this.firstName = firstname.target.value
    },
    onInputLastname(lastname) {
      this.lastName = lastname.target.value
    },
    onInputPhone(phone) {
      this.phoneNumber = phone.target.value
    },
    onInputDateOfBirth(date) {
      this.dateOfBirth = date.target.value
    },

    onInputCity(city) {
      this.city = city.target.value
    },

    onInputCountry(country) {
      this.country = country.target.value
    },

    onInputPostalCode(postalCode) {
      this.postalCode = postalCode.target.value
    },

    onInputStreetName(streetName) {
      this.streetName = streetName.target.value
    },

    onInputStreetNumber(streetNumber) {
      this.streetNumber = streetNumber.target.value
    },

    onLogin() {
      router.push("/login")
    }
  },
  setup() {
    const validationSchema = object({
      username: string("Wrong format").required("Cannot be empty"),
      email: string("Wrong format").email("Please enter a valid email").required("Cannot be empty"),
      password: string("Wrong format").required("Cannot be empty"),
      firstName: string("Wrong format").required("Cannot be empty"),
      lastName: string("Wrong format").required("Cannot be empty"),
      phoneNumber: number("Must be a number").positive("Must be positive").min(8, "Must be more than 8").required("Please enter a phone number"),
      dateOfBirth: date("Must be a valid date"),

      address: {
        city: string("Wrong format").required("Cannot be empty"),
        country: string("Wrong format").required("Cannot be empty"),
        postalCode: number("Must be a number").positive("Must be positive").min(1000, "Must be more than 999").max(9999, "Must be less than 10000").required("Please enter a phone number"),
        streetName: string("Wrong format").required("Cannot be empty"),
        streetNumber: string("Wrong format").required("Cannot be empty"),
      }

    });
    const {handleSubmit, errors} = useForm({
      validationSchema,
    });

    const {value: username} = useField("username");
    const {value: email} = useField("email");
    const {value: password} = useField("password");
    const {value: firstName} = useField("firstName");
    const {value: lastName} = useField("lastName");
    const {value: phoneNumber} = useField("phoneNumber");
    const {value: dateOfBirth} = useField("dateOfBirth")


    const {value: city} = useField("city")
    const {value: country} = useField("country")
    const {value: postalCode} = useField("postalCode");
    const {value: streetName} = useField("streetName");
    const {value: streetNumber} = useField("streetNumber");

    const submit = handleSubmit((values) => {
      userService.registerUser(values);
    });

    return {
      username,
      email,
      password,
      errors,
      firstName,
      lastName,
      phoneNumber,
      dateOfBirth,
      address: {
        city,
        country,
        postalCode,
        streetName,
        streetNumber
      },
      submit,
    };
  }
}
</script>

<style scoped>
.field {
  display: block;
  width: 80%;
  margin: 10px auto;
}

.Btn {
  margin: 20px auto;
  text-align: center;
}

#name {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-gap: 5%;
}

#registerBtn {
  background: #0b6dff;
  border: 0;
  padding: 10px 20px;
  width: 80%;
  color: white;
  border-radius: 5px;
}

#loginBtn {
  background: #b7b7b7;
  border: 0;
  padding: 10px 20px;
  width: 60%;
  color: black;
  border-radius: 5px;
}

#registerBtn:hover {
  background-color: #4169a8;
  cursor: pointer;
}

#loginBtn:hover {
  background-color: #d0cece;
  cursor: pointer;
}
</style>