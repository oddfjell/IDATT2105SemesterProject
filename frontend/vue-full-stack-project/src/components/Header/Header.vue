<template>
  <LoggedInNavBar v-if="isLoggedIn" />
  <default-nav-bar v-else/>
</template>

<script>
import DefaultNavBar from "@/components/Header/DefaultNavBar.vue";
import LoggedInNavBar from "@/components/Header/LoggedInNavBar.vue";
import {useTokenStore} from "@/stores/token";

export default {
  name: "DefaultHeader.vue",
  components: {LoggedInNavBar, DefaultNavBar},
  data(){
    return {
        isLoggedIn:Boolean
    }
  },
  created() {
    this.isLoggedIn=false;
    if( this.tokenStore.loggedInUser !=null){
      this.isLoggedIn=true;
    }
  },
  setup() {
    const tokenStore = useTokenStore();
    return { tokenStore };
  },
}
</script>

<style scoped>





</style>