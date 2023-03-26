<script setup>
import { RouterView } from 'vue-router'
import Footer from "@/components/Footer.vue";
import LogoHeader from "@/components/Header/LogoHeader.vue";

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
  <div id="pageContainer">
  <LogoHeader/>
  <RouterView />
  </div>
  <Footer/>
</template>

<style>
#pageContainer{
  position: relative;
  min-height: 100vh;
}
.container {
  max-width: 500px;
  margin: 30px auto;
  overflow: auto;
  border: 1px solid steelblue;
  padding: 30px;
  border-radius: 5px;
}
</style>
