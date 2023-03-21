<script setup>
import { RouterView } from 'vue-router'

</script>
<script>
import Header from "@/components/Header/Header.vue";

export default {
  name: "App",
  data(){
    return{
      components:Header
      }
  }
}
</script>
<template>
  <Header />
  <RouterView />
</template>

<style scoped>
</style>
