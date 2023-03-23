<template>
<header>
  <a class="link" href="/"><img id="logo" src="/Logo.svg" alt=""></a>
  <a class="link" href="/"><p id="title">Muligens et marked</p></a>
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
    this.isLoggedIn = false;
  }
}
</script>

<style scoped>

#logo{
  width: min(50vw, 150px);
  vertical-align: middle;

}

#title{
  vertical-align: middle;
  display: inline;
  color: white;
  padding: 0;
}
.link{
  text-decoration: none;
}
header {
  background: #1abc9c;
  color: white;
  font-size: x-large;
}
@media only screen and (max-width: 350px) {
  #title{
    display: none;
  }
}


</style>