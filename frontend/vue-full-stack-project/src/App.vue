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
