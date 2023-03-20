<template>
  <main>
    <h1>ELO</h1>
    <div id="item_grid">
    <div id="item" :key="item" v-for="item in items">
    <ItemComponent/>
    </div>
    </div>
  </main>
</template>

<script>
import ItemComponent from "@/components/Item.vue";

export default {
  name: "FrontPageView.vue",
  components: {ItemComponent},
  data(){
    return{
      props:{
        items:Array
      }
    }
  },
  created() {
    this.items=[1,2,3,4,5]
  }
}

</script>

<style scoped>
#item_grid{
  display: grid;
  grid-template-columns: fit-content(5%);
  grid-gap: 5%;
}

</style>