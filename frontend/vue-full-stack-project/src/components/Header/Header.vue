<template>
<header>
  <img id="logo" src="https://dieselpunkcore.com/wp-content/uploads/2014/06/logo-placeholder.png" alt="">
  <h1 id="title">Tittel</h1>
</header>
  <LoggedInNavBar v-if="isLoggedIn" />
  <default-nav-bar v-else/>
</template>

<script>
import DefaultNavBar from "@/components/Header/DefaultNavBar.vue";
import LoggedInNavBar from "@/components/Header/LoggedInNavBar.vue";

export default {
  name: "DefaultHeader.vue",
  components: {LoggedInNavBar, DefaultNavBar},
  data(){
    return {
        isLoggedIn:Boolean
    }
  },
  created() {
    this.isLoggedIn = true;
  }
}
</script>

<style scoped>

#logo{
  width: min(50vw, 150px);
}
#title{
  display: inline;
}
header {
  background: #1abc9c;
  color: white;
  font-size: xx-large;
}


</style>