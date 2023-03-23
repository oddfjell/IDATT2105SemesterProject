<script setup>
import { RouterView } from 'vue-router'
import Footer from "@/components/Footer.vue";

</script>
<script>
import Header from "@/components/Header/Header.vue";
import FooterComponent from "@/components/Footer.vue";

export default {
  name: "App",
  data(){
    return{
      components:Header, FooterComponent,
      }
  }
}
</script>
<template>
  <Header />
  <RouterView />
  <Footer/>
</template>

<style>
.container {
  max-width: 500px;
  margin: 30px auto;
  overflow: auto;
  min-height: 300px;
  border: 1px solid steelblue;
  padding: 30px;
  border-radius: 5px;
}
</style>
